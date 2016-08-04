package open.trivia.controllers;

import open.trivia.QA;
import open.trivia.services.OpenTriviaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpenTriviaControllerTest {

    @InjectMocks
    OpenTriviaController openTriviaController;

    @Mock
    OpenTriviaService openTriviaService;

    @Mock
    QA qa;

    @Test
    public void testGetRandomQA() throws Exception {
        when(openTriviaService.getRandomQA()).thenReturn(qa);
        when(qa.getQuestion()).thenReturn("What day is today?");
        when(qa.getAnswer()).thenReturn("Sunday");
        when(qa.getChoices()).thenReturn(new String[]{"Sunday", "Monday", "Wednesday", "Thursday"});

        QA result = openTriviaController.getRandomQA();

        assertThat(result.getQuestion(), is("What day is today?"));
        assertThat(result.getAnswer(), is("Sunday"));
        assertThat(result.getChoices()[0], is("Sunday"));
        assertThat(result.getChoices()[1], is("Monday"));
        assertThat(result.getChoices()[2], is("Wednesday"));
        assertThat(result.getChoices()[3], is("Thursday"));
    }

}