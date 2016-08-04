package open.trivia.controllers;

import open.trivia.QA;
import open.trivia.services.OpenTriviaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class OpenTriviaController {

    @Autowired
    OpenTriviaService openTriviaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/randomqa")
    public QA getRandomQA() {
        return openTriviaService.getRandomQA();
    }
}
