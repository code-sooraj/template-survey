package training.roadmap.survey.jdbc.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
public class JdbcTemplate {

	private DataSource dataSource;

	/**
	 * Construct a new JdbcTemplate, given a DataSource to obtain connections from.
	 * @param dataSource the JDBC DataSource to obtain connections from
	 */
	@Inject
	public JdbcTemplate(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws SQLException {
		return query(sql, new RowMapperResultSetExtractor<>(rowMapper));
	}

	public <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws SQLException {
		List<T> results = query(sql, rowMapper);
		return requiredSingleResult(results);
	}

	private void setDataSource(final DataSource pDataSource) {
		this.dataSource = pDataSource;
	}

	private DataSource getDataSource() {
		return dataSource;
	}

	public <T> T execute(StatementCallback<T> action) throws SQLException {
		Connection con = getDataSource().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			T result = action.doInStatement(stmt);
			return result;
		} catch (SQLException ex) {
			// Release Connection early, to avoid potential connection pool deadlock
			// in the case when the exception translator hasn't been initialized yet.
			stmt.close();
			con.close();
			throw ex;
		} finally {
			stmt.close();
			con.close();
		}
	}

	public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws SQLException {
		System.out.println("Executing SQL query [" + sql + "]");

		class QueryStatementCallback implements StatementCallback<T> {
			@Override
			public T doInStatement(Statement stmt) throws SQLException {
				ResultSet rs = null;
				try {
					rs = stmt.executeQuery(sql);
					return rse.extractData(rs);
				}
				finally {
					closeResultSet(rs);
				}
			}
			@Override
			public String getSql() {
				return sql;
			}
		}
		return execute(new QueryStatementCallback());
	}

	/**
	 * Close the given JDBC ResultSet and ignore any thrown exception.
	 * This is useful for typical finally blocks in manual JDBC code.
	 * @param rs the JDBC ResultSet to close (may be <code>null)
	 */
	private static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}
			catch (SQLException ex) {
				System.err.println("Could not close JDBC ResultSet" + ex.getMessage());
			}
			catch (Throwable ex) {
				// We don't trust the JDBC driver: It might throw RuntimeException or Error.
				System.err.println("Unexpected exception on closing JDBC ResultSet" + ex.getMessage());
			}
		}
	}

	/**
	 * Return a single result object from the given Collection.
	 * <p>Throws an exception if 0 or more than 1 element found.
	 * @param results the result Collection (can be {@code null})
	 * @return the single result object
	 * @throws IncorrectResultSizeDataAccessException if more than one
	 * element has been found in the given Collection
	 * @throws EmptyResultDataAccessException if no element at all
	 * has been found in the given Collection
	 */
	private static <T> T requiredSingleResult(Collection<T> results) {
		int size = (results != null ? results.size() : 0);
		if (size == 0) {
			throw new RuntimeException("Expected 1 result, found 0");
		}
		if (results.size() > 1) {
			throw new RuntimeException("Expected 1 result, found " + size);
		}
		return results.iterator().next();
	}
}

interface StatementCallback<T> {
	public T doInStatement(Statement stmt) throws SQLException;
	public String getSql();
}
