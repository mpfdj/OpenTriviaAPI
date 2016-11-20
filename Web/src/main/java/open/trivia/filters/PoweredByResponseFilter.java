package open.trivia.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/*
https://jersey.java.net/documentation/latest/filters-and-interceptors.html
The filter must 1. inherit from the ContainerResponseFilter and must be 2. REGISTERED AS A PROVIDER.
*/

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("X-Powered-By", "Jersey :-)");
    }
}
