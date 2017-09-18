package training.roadmap.survey;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import training.roadmap.survey.marshall.MarshallingFeature;
import training.roadmap.survey.rest.HelloService;
import training.roadmap.survey.rest.QuestionService;

@ApplicationPath("rest")
public class SurveyApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // Register resources.
        classes.add(MarshallingFeature.class);
        classes.add(QuestionService.class);
        classes.add(HelloService.class);
        return classes;
    }
}
