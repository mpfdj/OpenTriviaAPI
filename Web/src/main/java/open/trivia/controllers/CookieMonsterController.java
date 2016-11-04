package open.trivia.controllers;

import lombok.extern.slf4j.Slf4j;
import open.trivia.Status;
import open.trivia.exceptions.OpenTriviaException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*
add "127.0.0.1   jaeger.de.miel.org"  to "C:\Windows\System32\drivers\etc\hosts"
add alias jaeger.de.miel.org  to tomcat profile
*/

@Slf4j
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class CookieMonsterController {

    @GET
    @Path("/give-me-a-cookie")
    public Response giveMeACookie() {
        Status status = Status.ok("You've got a brand new XSRF-TOKEN cookie...");

        NewCookie cookies[] = new NewCookie[2];
        cookies[0] = getXSRFTOKENCookie("miel.org");
        cookies[1] = getXSRFTOKENCookie("de.miel.org");
        //cookies[2] = getXSRFTOKENCookie("jaeger.de.miel.org");

        return Response.ok().entity(status).cookie(cookies).build();
    }

    @GET
    @Path("/feed-cookie-monster")
    public Status feedCookieMonster(@CookieParam("XSRF-TOKEN") Cookie cookie) {
        if (cookie == null) {
            log.error("Cookie monster did not receive a XSRF-TOKEN cookie.");
            throw new OpenTriviaException(Response.Status.BAD_REQUEST, "Cookie monster did not receive a XSRF-TOKEN cookie.");
        }
        log.debug("Cookie monster is consuming cookie: {}", cookie);
        log.debug("Cookie path is: {}", cookie.getPath());
        log.debug("Cookie domain is: {}", cookie.getDomain());
        // Do some CSRF validation here...
        return Status.ok("Cookie monster successfully eat your cookie...");
    }

    @GET
    @Path("/feed-greedy-cookie-monster")
    public Status feedGreedyCookieMonster(@Context HttpHeaders hh) {
        Map<String, Cookie> cookies = hh.getCookies();
        log.debug("The greedy cookie monster is consuming {} cookies: {}", cookies.size(), cookies);
        return Status.ok("Cookie monster successfully eat your cookie...");
    }

    private NewCookie getXSRFTOKENCookie(String domain) {
        /*
        * @param name    the name of the cookie.
        * @param value   the value of the cookie.
        * @param path    the URI path for which the cookie is valid.
        * @param domain  the host domain for which the cookie is valid.
        * @param comment the comment.
        * @param maxAge  the maximum age of the cookie in seconds.
        * @param secure  specifies whether the cookie will only be sent over a secure connection.
         */
        String token = UUID.randomUUID().toString();
        return new NewCookie("XSRF-TOKEN", token, "/", domain, "XSRF-TOKEN", 60, false);
    }
}
