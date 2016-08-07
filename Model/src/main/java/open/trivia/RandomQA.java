package open.trivia;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true, includeFieldNames=true)
public class RandomQA extends QA {
    private String category;
}
