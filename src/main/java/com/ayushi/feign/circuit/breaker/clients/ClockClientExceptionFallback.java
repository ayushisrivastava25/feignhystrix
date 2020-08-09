package com.ayushi.feign.circuit.breaker.clients;

import feign.FeignException;

public class ClockClientExceptionFallback implements ClockClient {

    private final Throwable cause;

    public ClockClientExceptionFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public Integer getClockCount(String type) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            // Treat the HTTP 404 status
        }

        return 0;
    }

}