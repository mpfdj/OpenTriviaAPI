package open.trivia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private StatusCode statusCode;
    private String statusMessage;

    public static Status ok(String message) {
        return new Status(StatusCode.OK, message);
    }
}