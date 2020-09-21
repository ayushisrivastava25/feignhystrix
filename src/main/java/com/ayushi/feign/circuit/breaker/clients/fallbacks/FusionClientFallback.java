package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.FusionClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FusionClientFallback implements FusionClient {

    private final Throwable cause;

    public FusionClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public Integer getFusionSongsCount() {
//        if (cause instanceof FeignException) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            log.info("fallback in fusion client call ; reason was: " + cause.getMessage());
        }
        return 10;
    }

}