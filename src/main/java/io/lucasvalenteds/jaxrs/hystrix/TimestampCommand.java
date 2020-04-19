package io.lucasvalenteds.jaxrs.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.time.LocalDateTime;

public class TimestampCommand extends HystrixCommand<String> {

    private final boolean shouldFail;

    TimestampCommand(boolean shouldFail) {
        super(HystrixCommandGroupKey.Factory.asKey("timestamps"));
        this.shouldFail = shouldFail;
    }

    @Override
    protected String run() {
        if (shouldFail) {
            throw new RuntimeException("Could not get timestamp");
        } else {
            return String.format("{\"timestamp\": \"%s\"}", LocalDateTime.now());
        }
    }
}
