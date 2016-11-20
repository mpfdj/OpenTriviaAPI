package open.trivia.configurations;

import open.trivia.exceptions.OpenTriviaExceptionMapper;
import open.trivia.filters.CrossDomainFilter;
import open.trivia.filters.PoweredByResponseFilter;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class JerseyResourceConfig extends ResourceConfig {

    public JerseyResourceConfig() {
        // super(JacksonFeature.class, MielsExceptionMapper.class);
        register(JacksonFeature.class);
        register(OpenTriviaExceptionMapper.class);
        register(CrossDomainFilter.class);
        register(PoweredByResponseFilter.class);
        register(LoggingFilter.class);  // basic Jersey input / output logging

        // TODO: 12-11-2016 implement a ConstraintViolationExceptionMapper 
        
        // https://jersey.java.net/documentation/latest/bean-validation.html
        // 18.3. Configuring Bean Validation Support
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        // https://jersey.java.net/documentation/latest/deployment.html
        // enable scanning for root resource and PROVIDER CLASSES in a provided classpath or a in a set of package names etc
        packages("open.trivia");
    }
}