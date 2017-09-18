package training.roadmap.survey.dao;

import java.sql.SQLException;

import training.roadmap.survey.dto.Question;

public interface QuestionDao {

	public Question getFirstQuestion(final String emailId) throws SQLException;

	public Question getNextQuestion(final int index) throws SQLException;
}
