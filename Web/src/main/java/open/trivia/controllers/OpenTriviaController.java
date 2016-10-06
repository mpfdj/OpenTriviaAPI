package open.trivia.controllers;

import open.trivia.Category;
import open.trivia.QA;
import open.trivia.Status;
import open.trivia.UserPreference;
import open.trivia.exceptions.OpenTriviaException;
import open.trivia.services.OpenTriviaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class OpenTriviaController {

    @Autowired
    OpenTriviaService openTriviaService;

    @GET
    @Path("/qa")
    public QA getQA() {
        return openTriviaService.getQA();
    }

    @GET
    @Path("/qa/{category}")
    public QA getQA(@NotNull @PathParam("category") String category) {
        boolean b = openTriviaService.getCategoryNames().contains(category);
        if (!openTriviaService.getCategoryNames().contains(category))
            throw new OpenTriviaException(Response.Status.NOT_FOUND, "Category not found.");
        return openTriviaService.getQA(category);
    }

    @GET
    @Path("/categories")
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        for (String cn: openTriviaService.getCategoryNames()) {
            categories.add(new Category(cn));
        }
        return categories;
    }

    @POST
    @Path("/userpreference")
    public Status storeUserPreference(UserPreference preference) {
        // return cookie
        // create status object
        return null;
    }
}
