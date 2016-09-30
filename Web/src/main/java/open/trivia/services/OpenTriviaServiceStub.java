package open.trivia.services;

import open.trivia.QA;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Profile("stub")
public class OpenTriviaServiceStub implements OpenTriviaService {

    public OpenTriviaServiceStub() {
    }

    @Override
    public List<String> getCategoryNames() {
        return Arrays.asList("animals", "brain-teasers", "celebrities");
    }

    @Override
    public QA getQA() {
        QA qa = new QA();
        qa.setQuestion("What is the literal translation of the Greek word Embioptera, which denotes an order of insects, also known as webspinners?");
        qa.setAnswer("Lively wings");
        qa.setChoices(new String[]{"Small wings", "None of these", "Yarn knitter", "Lively wings"});
        qa.setCategory("animals");
        return qa;
    }

    @Override
    public QA getQA(String categoryName) {
        return getQA();
    }

}
