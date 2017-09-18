package training.roadmap.survey.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import training.roadmap.survey.dto.Choice;
import training.roadmap.survey.dto.Question;
import training.roadmap.survey.jdbc.core.RowMapper;

public class QuestionMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		String questionId = rs.getString("ID");
		int qOrderId = rs.getInt("Q_ORDER");
		String surveyId = rs.getString("SURVEY_ID");
		String questionPhrase = rs.getString("Q_PHRASE");
		List<Choice> choices = new ArrayList<Choice>(5);
		Question question = new Question(
				questionId, qOrderId, surveyId, questionPhrase, choices);
		return question;
	}
}
