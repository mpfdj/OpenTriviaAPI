package open.trivia.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


@Conditional(ExcludeCondition.class)
@Service
public class LocalResourcesService {

    @Value("classpath:/animals.json")
    private Resource animalData;

    public LocalResourcesService() {
        System.out.println("Fetching data for class: " + animalData.getClass());
    }

}
