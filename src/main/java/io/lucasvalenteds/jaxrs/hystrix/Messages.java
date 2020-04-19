package io.lucasvalenteds.jaxrs.hystrix;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/messages")
public class Messages {

    @GET
    public List<String> getAll(@QueryParam("shouldFail") boolean shouldFail) {
        return new MessagesCommand(shouldFail).execute();
    }
}
