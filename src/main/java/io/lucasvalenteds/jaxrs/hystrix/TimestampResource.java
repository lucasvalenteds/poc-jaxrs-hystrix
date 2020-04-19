package io.lucasvalenteds.jaxrs.hystrix;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/timestamp")
@Produces(MediaType.APPLICATION_JSON)
public class TimestampResource {

    @GET
    public String generateTimestamp(@QueryParam("shouldFail") boolean shouldFail) {
        return new TimestampCommand(shouldFail).execute();
    }
}
