package open.trivia.exceptions;

import lombok.extern.slf4j.Slf4j;
import open.trivia.Status;
import open.trivia.StatusCode;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class OpenTriviaExceptionMapper implements ExceptionMapper<OpenTriviaException> {

    @Override
    public Response toResponse(OpenTriviaException exception) {
        log.error(exception.toString());
        Status status = new Status();
        status.setStatusCode(StatusCode.NOK);
        status.setStatusMessage(exception.getMessage());
        return Response.status(exception.getResponseStatus()).entity(status).build();
    }

}

