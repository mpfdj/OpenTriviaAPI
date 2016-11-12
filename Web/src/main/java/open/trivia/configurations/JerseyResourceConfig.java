package open.trivia.configurations;

import open.trivia.exceptions.OpenTriviaExceptionMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class JerseyResourceConfig extends ResourceConfig {

    public JerseyResourceConfig() {
        // super(JacksonFeature.class, MielsExceptionMapper.class);

        register(JacksonFeature.class);
        register(OpenTriviaExceptionMapper.class);

        // TODO: 12-11-2016 implement a ConstraintViolationExceptionMapper 
        
        // https://jersey.java.net/documentation/latest/bean-validation.html
        // 18.3. Configuring Bean Validation Support
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        // https://jersey.java.net/documentation/latest/deployment.html
        // enable scanning for root resource and provider classes in a provided classpath or a in a set of package names etc
        packages("open.trivia");
    }
}