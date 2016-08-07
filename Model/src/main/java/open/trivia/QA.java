package open.trivia;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QA {
    private String question;
    private String answer;
    private String[] choices;
    private String category;
}
