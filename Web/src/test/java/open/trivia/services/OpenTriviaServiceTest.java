package open.trivia.services;

import open.trivia.configurations.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class OpenTriviaServiceTest {

    @Autowired
    OpenTriviaService openTriviaService;

    @Test
    public void testCategoryNames() {
        List<String> categoryNames = openTriviaService.getCategoryNames();
        assertThat(categoryNames.size(), is(2));
        assertThat(categoryNames.get(0), is("animals"));
        assertThat(categoryNames.get(1), is("brain-teasers"));
    }

    @Test
    public void testGetRandomQA() {
        System.out.println(openTriviaService.getRandomQA());
    }

}
