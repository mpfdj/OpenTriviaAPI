package open.trivia.controllers;

import open.trivia.QA;
import open.trivia.services.OpenTriviaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpenTriviaControllerTest {

    @InjectMocks
    OpenTriviaController openTriviaController;

    @Mock (answer = Answers.RETURNS_DEEP_STUBS)
    OpenTriviaService openTriviaService;

    @Mock
    QA qa;

    @Test
    public void testGetQA() throws Exception {
        when(openTriviaService.getQA()).thenReturn(qa);
        when(qa.getQuestion()).thenReturn("What day is today?");
        when(qa.getAnswer()).thenReturn("Sunday");
        when(qa.getChoices()).thenReturn(new String[]{"Sunday", "Monday", "Wednesday", "Thursday"});
        when(qa.getCategory()).thenReturn("Miscellaneous");

        QA result = openTriviaController.getQA();

        assertThat(result.getQuestion(), is("What day is today?"));
        assertThat(result.getAnswer(), is("Sunday"));
        assertThat(result.getChoices()[0], is("Sunday"));
        assertThat(result.getChoices()[1], is("Monday"));
        assertThat(result.getChoices()[2], is("Wednesday"));
        assertThat(result.getChoices()[3], is("Thursday"));
        assertThat(result.getCategory(), is("Miscellaneous"));
    }

    @Test
    public void testGetQAPerCategory() throws Exception {
        when(openTriviaService.getCategoryNames().contains(anyString())).thenReturn(true);
        when(openTriviaService.getQA(anyString())).thenReturn(qa);
        when(qa.getQuestion()).thenReturn("What day is today?");
        when(qa.getAnswer()).thenReturn("Sunday");
        when(qa.getChoices()).thenReturn(new String[]{"Sunday", "Monday", "Wednesday", "Thursday"});
        when(qa.getCategory()).thenReturn("Miscellaneous");

        QA result = openTriviaController.getQA("xxx");

        assertThat(result.getQuestion(), is("What day is today?"));
        assertThat(result.getAnswer(), is("Sunday"));
        assertThat(result.getChoices()[0], is("Sunday"));
        assertThat(result.getChoices()[1], is("Monday"));
        assertThat(result.getChoices()[2], is("Wednesday"));
        assertThat(result.getChoices()[3], is("Thursday"));
        assertThat(result.getCategory(), is("Miscellaneous"));
    }
}