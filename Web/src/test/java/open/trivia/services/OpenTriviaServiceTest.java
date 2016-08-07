package open.trivia.services;

import open.trivia.QA;
import open.trivia.configurations.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class OpenTriviaServiceTest {

    @Autowired
    OpenTriviaService openTriviaService;

    @Test
    public void testCategoryNames() {
        List<String> categoryNames = openTriviaService.getCategoryNames();
        assertThat(categoryNames.size(), is(22));
        assertThat(categoryNames.get(0), is("animals"));
        assertThat(categoryNames.get(1), is("brain-teasers"));
        assertThat(categoryNames.get(2), is("celebrities"));
        assertThat(categoryNames.get(3), is("entertainment"));
        assertThat(categoryNames.get(4), is("for-kids"));
        assertThat(categoryNames.get(5), is("general"));
        assertThat(categoryNames.get(6), is("geography"));
        assertThat(categoryNames.get(7), is("history"));
        assertThat(categoryNames.get(8), is("hobbies"));
        assertThat(categoryNames.get(9), is("humanities"));
        assertThat(categoryNames.get(10), is("literature"));
        assertThat(categoryNames.get(11), is("movies"));
        assertThat(categoryNames.get(12), is("music"));
        assertThat(categoryNames.get(13), is("newest"));
        assertThat(categoryNames.get(14), is("people"));
        assertThat(categoryNames.get(15), is("rated"));
        assertThat(categoryNames.get(16), is("religion-faith"));
        assertThat(categoryNames.get(17), is("science-technology"));
        assertThat(categoryNames.get(18), is("sports"));
        assertThat(categoryNames.get(19), is("television"));
        assertThat(categoryNames.get(20), is("video-games"));
        assertThat(categoryNames.get(21), is("world"));
    }

    @Test
    public void testGetRandomQA() {
        QA randomQA = openTriviaService.getRandomQA();
        System.out.println(randomQA);
        assertThat(randomQA.getQuestion(), is(notNullValue()));
        assertThat(randomQA.getChoices(), is(notNullValue()));
        assertThat(randomQA.getAnswer(), is(notNullValue()));
        assertThat(randomQA.getCategory(), is(notNullValue()));
    }

}
