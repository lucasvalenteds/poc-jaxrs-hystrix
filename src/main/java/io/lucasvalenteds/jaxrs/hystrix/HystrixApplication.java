package io.lucasvalenteds.jaxrs.hystrix;

import com.netflix.hystrix.contrib.metrics.HystrixStreamFeature;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HystrixApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>(0);

        resources.add(Messages.class);
        resources.add(HystrixStreamFeature.class);

        return resources;
    }
}
