package open.trivia.configurations;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SpringConfigTest {

    private static AnnotationConfigWebApplicationContext context;

    @BeforeClass
    public static void setUp() {
        context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();
    }

    @Test
    public void printContext() {
        System.out.println("id: " + context.getId());
        System.out.println("displayName: " + context.getDisplayName());
        System.out.println("applicationName: " + context.getApplicationName());
        System.out.println("configLocations: " + Arrays.toString(context.getConfigLocations()));
        System.out.println("systemEnvironment: " + context.getEnvironment().getSystemEnvironment());
        System.out.println("systemProperties: " + context.getEnvironment().getSystemProperties());
        System.out.println("namespace: " + context.getNamespace());
    }

    @Test
    public void printBeanDefinitionNames() {
        List<String> names = new ArrayList<String>(Arrays.asList(context.getBeanDefinitionNames()));
        Collections.sort(names);

        int i = 1;
        for (String name : names) {
            System.out.println(i + ": " + name);
            i++;
        }
    }

    @Test
    public void printConfig() {
        // Nothing special here
        SpringConfig springConfig = (SpringConfig) context.getBean("springConfig");
        System.out.println(springConfig.toString());
    }

}
