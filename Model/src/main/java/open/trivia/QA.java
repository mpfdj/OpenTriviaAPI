package open.trivia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class QA {
    private String question;
    private String answer;
    private String[] choices;
}
