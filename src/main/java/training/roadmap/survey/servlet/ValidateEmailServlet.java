package training.roadmap.survey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateEmail")
@MultipartConfig
public class ValidateEmailServlet extends HttpServlet {

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		// read form fields
        final String corpMail = request.getParameter("corpMail");
        System.out.println("Corporate Email Address: " + corpMail);
        if (isAValidCorporateMail(corpMail)) {
        	response.setStatus(response.SC_OK);
        	response.getWriter().write(getQuestionServiceUrl(request));
        	response.getWriter().flush();
        	response.getWriter().close();
        } else {
        	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        	response.getWriter().write("Enter a valid email address");
        	response.getWriter().flush();
        	response.getWriter().close();
        }
	}

	private boolean isAValidCorporateMail(final String corpMail) {
		if (corpMail == null || corpMail.isEmpty()) {
        	return false;
        }
		return true;
	}

	private String getQuestionServiceUrl(final HttpServletRequest request) {
		final String uri = request.getScheme() + "://" +   // "http" + "://
	             request.getServerName() +       // "myhost"
	             ":" +                           // ":"
	             request.getServerPort() +
	             "/survey";
		return uri;
	             
	}
}
