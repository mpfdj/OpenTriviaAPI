package open.trivia;

import lombok.Data;
import lombok.ToString;

@Data
public class QA {
    private String question;
    private String answer;
    private String[] choices;
}
