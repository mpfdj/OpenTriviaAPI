package open.trivia.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import open.trivia.QA;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenTriviaService {

    private final List<String> categoryNames = new ArrayList<>();
    private final Map<String, QA[]> categories = new HashMap<>();

    {
        categoryNames.add("animals");
        categoryNames.add("brain-teasers");
        categoryNames.add("celebrities");
        categoryNames.add("entertainment");
        categoryNames.add("for-kids");
        categoryNames.add("general");
        categoryNames.add("geography");
        categoryNames.add("history");
        categoryNames.add("hobbies");
        categoryNames.add("humanities");
        categoryNames.add("literature");
        categoryNames.add("movies");
        categoryNames.add("music");
        categoryNames.add("newest");
        categoryNames.add("people");
        categoryNames.add("rated");
        categoryNames.add("religion-faith");
        categoryNames.add("science-technology");
        categoryNames.add("sports");
        categoryNames.add("television");
        categoryNames.add("video-games");
        categoryNames.add("world");
    }

    public OpenTriviaService() throws IOException {
        for (String categoryName : categoryNames) {
            addCategory(categoryName);
        }
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public QA getRandomQA() {
        String randomCategoryName = categoryNames.get(getRandomNumber(categoryNames.size()));
        QA[] randomCategory = categories.get(randomCategoryName);
        QA qa = randomCategory[getRandomNumber(randomCategory.length)];
        qa.setCategory(randomCategoryName);
        return qa;
    }

/*    private void addCategory(String categoryName) throws IOException {
        URL url = Resources.getResource(categoryName + ".json");
        ObjectMapper objectMapper = new ObjectMapper();
        QA qa[] = objectMapper.readValue(url, QA[].class);
        categories.put(categoryName, qa);
    }*/

    private void addCategory(String categoryName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(categoryName + ".json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        QA qa[] = objectMapper.readValue(file, QA[].class);
        categories.put(categoryName, qa);
    }

    private int getRandomNumber(int i) {
        return (int) (Math.random() * i);
    }


}
