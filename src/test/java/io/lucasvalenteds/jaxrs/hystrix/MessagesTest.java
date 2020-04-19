package io.lucasvalenteds.jaxrs.hystrix;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagesTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Messages.class);
    }

    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
    }

    @AfterEach
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testItReturnMessagesForSuccess() {
        Response response = target("/messages")
                .queryParam("shouldFail", false)
                .request()
                .get();

        List<String> body = response.readEntity(new GenericType<>() {
        });

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(List.of("Hello World!"), body);
    }

    @Test
    public void testItReturnsEmptyStringForFailure() {
        Response response = target("/messages")
                .queryParam("shouldFail", true)
                .request()
                .get();

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }
}
