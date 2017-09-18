package training.roadmap.survey.rest;

import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import training.roadmap.survey.dao.Dao;
import training.roadmap.survey.dao.QuestionDao;
import training.roadmap.survey.dto.Question;

@Path("/question")
@ApplicationScoped
@Named("questionService")
public class QuestionService {

	@Inject @Dao
	private QuestionDao questionDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFirstQuestion(final String emailId) throws SQLException {
		Question question = questionDao.getFirstQuestion(emailId);
		return Response.ok(question).build();
	}

	@GET
	@Path("/{currentQid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNextQuestion(int currentQid) throws SQLException {
		Question question = questionDao.getNextQuestion(currentQid);
		return Response.ok(question).build();
	}
}
