package open.trivia.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import open.trivia.QA;
import open.trivia.configurations.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@ActiveProfiles("development")
public class LocalResourcesTest {

//    @Autowired
//    LocalResourcesService localResourcesService;

    @Value("classpath:/animals.json")
    private Resource animalData;

    @Test
    public void test() {
        try (InputStream inputStream = animalData.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            QA qa[] = objectMapper.readValue(inputStream, QA[].class);
            System.out.println(Arrays.toString(qa));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
