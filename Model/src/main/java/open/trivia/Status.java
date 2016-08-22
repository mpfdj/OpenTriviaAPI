package open.trivia;

import lombok.Data;

@Data
public class Status {
    private StatusCode statusCode;
    private String statusMessage;
}