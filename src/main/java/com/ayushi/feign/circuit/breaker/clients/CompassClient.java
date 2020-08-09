package com.ayushi.feign.circuit.breaker.clients;

import com.ayushi.feign.circuit.breaker.clients.fallbacks.CompassClientFallbackFactory;
import com.ayushi.feign.circuit.breaker.config.ClockServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "compass", url = "${feign.clients.clock.baseUri}", configuration = ClockServiceConfig.class, fallbackFactory = CompassClientFallbackFactory.class)
public interface CompassClient {

    @GetMapping("/v1/compass")
    Integer getCompassCount();
}
