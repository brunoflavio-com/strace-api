package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HelloControllerTest {

    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class); // <1>
        client = server
                .getApplicationContext()
                .createBean(HttpClient.class, server.getURL());  // <2>
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void testStrace() throws Exception {
        HttpRequest request = HttpRequest.GET("/strace"); // <3>
        String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
        assertEquals(
                body,
                "use /strace/PID/NUMBER_OF_LINES"
        );
    }
}
