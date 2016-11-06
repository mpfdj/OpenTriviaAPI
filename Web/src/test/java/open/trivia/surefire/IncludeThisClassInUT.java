package open.trivia.surefire;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Properties;

//http://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html

public class IncludeThisClassInUT {

    @Test
    public void helloTest() {
        // see maven-surefire-plugin in the Web module
        System.out.println("helloTest!!! If you see me this means the default setting of maven-surefire-plugin are overridden...");
    }

    @Test
    public void helloSystemProperty() {
        System.out.println("propertyName: " + System.getProperty("propertyName"));
        System.out.println("buildDirectory: " + System.getProperty("buildDirectory"));
        System.out.println("propertyNameDeprecated: " + System.getProperty("propertyNameDeprecated"));
    }

    @Test
    @Ignore
    public void displayAllSystemProperties() {
        Properties props = System.getProperties();
        props.list(System.out);
    }
}
