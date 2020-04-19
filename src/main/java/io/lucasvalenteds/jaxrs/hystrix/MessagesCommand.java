package io.lucasvalenteds.jaxrs.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.ArrayList;
import java.util.List;

public class MessagesCommand extends HystrixCommand<List<String>> {

    private final boolean shouldFail;

    MessagesCommand(boolean shouldFail) {
        super(HystrixCommandGroupKey.Factory.asKey("messages"));
        this.shouldFail = shouldFail;
    }

    @Override
    protected List<String> run() throws Exception {
        if (shouldFail) {
            throw new RuntimeException("Endpoint unavailable");
        } else {
            List<String> messages = new ArrayList<>(0);

            messages.add("Hello World!");

            return messages;
        }
    }
}
