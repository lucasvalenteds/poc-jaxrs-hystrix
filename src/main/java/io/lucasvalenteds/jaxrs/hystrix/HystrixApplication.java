package io.lucasvalenteds.jaxrs.hystrix;

import com.netflix.hystrix.contrib.metrics.HystrixStreamFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class HystrixApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>(0);

        resources.add(TimestampResource.class);
        resources.add(HystrixStreamFeature.class);

        return resources;
    }
}
