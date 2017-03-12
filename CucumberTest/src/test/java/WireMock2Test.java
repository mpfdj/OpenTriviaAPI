import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WireMock2Test {

    @Test
    public void test() {
//        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089).usingFilesUnderClasspath("src\\test\\resources"));
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089));
        wireMockServer.start();
        configureFor("localhost", 8089);
        reset();

//        stubFor(get(urlEqualTo("/api/savings/me/proposals/for-opening/1000"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json;charset=utf-8")
//                        .withBodyFile("__files/proposals/proposals-error.json")));

//        stubFor(get(urlEqualTo("/api/savings/me/proposals/for-opening/1000"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json;charset=utf-8")
//                        .withBody("hello")));

        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));

        wireMockServer.stop();
    }


}
