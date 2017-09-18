package training.roadmap.survey.singleton;

import javax.inject.Singleton;

import org.sqlite.javax.SQLiteConnectionPoolDataSource;

@Singleton
public class SurveyDatasource extends SQLiteConnectionPoolDataSource {

	public SurveyDatasource() {
		String path = "C:/DEMO/workspaces/training-roadmap/template-survey/target/template-survey/WEB-INF/classes/";
		StringBuilder urlBuilder = new StringBuilder("jdbc:sqlite:");
		urlBuilder.append(path);
		urlBuilder.append("survey.db");
		System.err.println(urlBuilder.toString());
		setUrl(urlBuilder.toString());
	}
}
