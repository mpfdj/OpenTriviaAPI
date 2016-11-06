package open.trivia;

import lombok.*;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private StatusCode statusCode;
    private String statusMessage;

    public static Status ok(String message) {
        return new Status(StatusCode.OK, message);
    }
}