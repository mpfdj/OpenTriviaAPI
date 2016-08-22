package open.trivia;

import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RestClientTest {

    @Test
    public void testGetQAUsingRestClient() {

        WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:9292/api/opentrivia");

        final Response response = webTarget
                .path("/qa")
                .request()
                .buildGet()
                .invoke();

        QA qa = response.readEntity(QA.class);
        System.out.println(qa);
        assertThat(qa.getQuestion(), is(notNullValue()));
        assertThat(qa.getChoices(), is(notNullValue()));
        assertThat(qa.getAnswer(), is(notNullValue()));
        assertThat(qa.getCategory(), is(notNullValue()));

    }

}
