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
    public void testGetRandomQAUsingRestClient() {

        WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:9292/api/opentrivia");

        final Response response = webTarget
                .path("/randomqa")
                .request()
                .buildGet()
                .invoke();

        QA randomQA = response.readEntity(QA.class);
        System.out.println(randomQA);
        assertThat(randomQA.getQuestion(), is(notNullValue()));
        assertThat(randomQA.getChoices(), is(notNullValue()));
        assertThat(randomQA.getAnswer(), is(notNullValue()));
        assertThat(randomQA.getCategory(), is(notNullValue()));

    }

}
