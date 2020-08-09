package com.ayushi.feign.circuit.breaker.clients;

import org.springframework.stereotype.Component;

@Component
public class ClockClientFallback implements ClockClient {

    @Override
    public Integer getClockCount(String type) {
        return 10;
    }
}