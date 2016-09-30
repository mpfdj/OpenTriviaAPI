package open.trivia.configurations;

import open.trivia.services.OpenTriviaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@ActiveProfiles("development")
public class ConfigTest {

    @Autowired
    OpenTriviaService openTriviaService;


    @Test
    public void testOpenTriviaServiceBean() {
        assertNotNull(openTriviaService);
    }
}
