package com.ayushi.feign.circuit.breaker.clients;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ClockClientFallbackFactory implements FallbackFactory<ClockClient> {

    @Override
    public ClockClient create(Throwable throwable) {
        return new ClockClientExceptionFallback(throwable);
    }
}
