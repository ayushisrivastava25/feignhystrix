package com.ayushi.feign.circuit.breaker.clients;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClockClientFallback2 implements FallbackFactory<ClockClient> {

    @Override
    public ClockClient create(Throwable cause) {
        return new ClockClient() {
            @Override
            public Integer getClockCount(String type) {
                log.info("fallback; reason was: " + cause.getMessage());
                return 7;
            }
        };
    }
}