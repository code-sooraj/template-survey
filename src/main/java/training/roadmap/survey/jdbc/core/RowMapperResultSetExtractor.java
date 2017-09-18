package training.roadmap.survey.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RowMapperResultSetExtractor<T> implements ResultSetExtractor<List<T>> {

	private final RowMapper<T> rowMapper;

	/**
	 * Create a new RowMapperResultSetExtractor.
	 * @param pRowMapper the RowMapper which creates an object for each row
	 */
	public RowMapperResultSetExtractor(RowMapper<T> pRowMapper) {
		this.rowMapper = pRowMapper;
	}

	@Override
	public List<T> extractData(ResultSet rs) throws SQLException {
		List<T> results = (new ArrayList<T>());
		int rowNum = 0;
		while (rs.next()) {
			results.add(this.rowMapper.mapRow(rs, rowNum++));
		}
		return results;
	}
}
