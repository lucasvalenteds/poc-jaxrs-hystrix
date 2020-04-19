package io.lucasvalenteds.jaxrs.hystrix;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimestampResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(TimestampResource.class);
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
        Response response = target("/timestamp").request().get();

        String body = response.readEntity(String.class);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString("Content-Type"));
        assertFalse(body.isEmpty());
    }

    @Test
    public void testItReturnsEmptyStringForFailure() {
        Response response = target("/timestamp")
                .queryParam("shouldFail", true)
                .request()
                .get();

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
        assertTrue(response.getHeaderString("Content-Type").contains(MediaType.TEXT_HTML));
    }
}
