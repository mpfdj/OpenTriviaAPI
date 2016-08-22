package open.trivia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.ws.rs.core.Response;

@Getter
@ToString
@AllArgsConstructor
public class OpenTriviaException extends RuntimeException {
    private Response.Status responseStatus;
    private String message;
}
