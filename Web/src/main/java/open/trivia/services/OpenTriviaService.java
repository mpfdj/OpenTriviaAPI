package open.trivia.services;

import open.trivia.QA;

import java.util.List;

public interface OpenTriviaService {
    List<String> getCategoryNames();
    QA getQA();
    QA getQA(String categoryName);
}
