package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.CompassClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompassClientFallback implements CompassClient {

    private final Throwable cause;

    public CompassClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public Integer getCompassCount() {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            // Treat the HTTP 404 status
            log.info("fallback in compass client call ; reason was: " + cause.getMessage());
        }
        return 10;
    }

}