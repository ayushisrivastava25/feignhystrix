package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.ClassicalClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClassicalClientFallback implements ClassicalClient {

    // quick and easy sample for Fallback without digging deeper into the actual issue which triggered fallbacked code execution
    @Override
    public Integer getClassicalSongsCount(String type) {
        log.info("fallback in classical client call" );
        return 10;
    }
}