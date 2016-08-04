package open.trivia.configurations;

import org.apache.jasper.servlet.JspServlet;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


// Cannot initialize context because there is already a root application context present
@Order(value = 5)

// Configure the given ServletContext with any servlets, filters, listeners, context-params and attributes necessary for initializing this web application
public class WebInitialization implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {

        servletContext.setInitParameter("contextConfigLocation", SpringConfig.class.getName());
        servletContext.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Register and map the dispatcher servlet
        final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", ServletContainer.class);
        dispatcher.setInitParameter("jersey.config.server.provider.packages", "open.trivia.controllers");
        dispatcher.setInitParameter("javax.ws.rs.Application", JerseyResourceConfig.class.getCanonicalName());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");

        // With this more "precise" definition of the JasperServlet, the jsp will be handled by JasperServlet instead of Jersey servlet (/*).
        // This jsp is just for basic testing
        final ServletRegistration.Dynamic jsp = servletContext.addServlet("jsp", JspServlet.class);
        jsp.setLoadOnStartup(2);
        jsp.addMapping("/index.jsp");
    }


}