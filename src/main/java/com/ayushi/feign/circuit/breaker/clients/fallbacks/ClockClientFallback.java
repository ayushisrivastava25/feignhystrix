package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.ClockClient;
import org.springframework.stereotype.Component;

@Component
public class ClockClientFallback implements ClockClient {

    // quick and easy sample for Fallback without digging deeper into the actual issue which triggered fallbacked code execution
    @Override
    public Integer getClockCount(String type) {
        return 10;
    }
}