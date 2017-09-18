package training.roadmap.survey.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import training.roadmap.survey.dto.Choice;
import training.roadmap.survey.dto.Question;
import training.roadmap.survey.jdbc.core.JdbcTemplate;

@Dao
public class QuestionDaoImpl implements QuestionDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Question getFirstQuestion(final String emailId) throws SQLException {
		Question question = jdbcTemplate.queryForObject(
				"select ID, Q_ORDER, SURVEY_ID, Q_PHRASE from QUESTION where ID = 1",
				new QuestionMapper());
		return question;
	}

	@Override
	public Question getNextQuestion(final int index) throws SQLException {
		Question question = jdbcTemplate.queryForObject(
				"select ID, Q_ORDER, SURVEY_ID, Q_PHRASE from QUESTION where ID = " + (index + 1),
				new QuestionMapper());
		return question;
	}

	/*
	 * 	public Question getNextQuestion(final int index) {
		final List<Choice> choices = new ArrayList<Choice>(4);
		choices.add(new Choice(getChoiceValue(index), getChoiceText(index)));
		choices.add(new Choice(getChoiceValue(index + 1), getChoiceText(index + 1)));
		choices.add(new Choice(getChoiceValue(index + 2), getChoiceText(index + 2)));
		choices.add(new Choice(getChoiceValue(index + 3), getChoiceText(index + 3)));
		Question question = new Question("1", 0, "1", "Test Question", choices);
		return question;
	}

	 */
	private String getChoiceValue(int index) {
		final StringBuilder builder = new StringBuilder("Test Choice ");
		builder.append(index);
		builder.append(" Value");
		return builder.toString();
	}

	private String getChoiceText(int index) {
		final StringBuilder builder = new StringBuilder("Test Choice ");
		builder.append(index);
		builder.append(" Text");
		return builder.toString();
	}
}
