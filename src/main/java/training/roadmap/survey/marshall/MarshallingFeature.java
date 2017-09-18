package training.roadmap.survey.marshall;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

public class MarshallingFeature implements Feature {

	@Override
	public boolean configure(FeatureContext context) {
        //context.register(MoxyJsonFeature.class, JsonMoxyConfigurationContextResolver.class, MessageBodyReader.class, MessageBodyWriter.class);
        return true;
	}
}
