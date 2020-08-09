package com.ayushi.feign.circuit.breaker.clients;

import com.ayushi.feign.circuit.breaker.clients.fallbacks.ClockClientFallback;
import com.ayushi.feign.circuit.breaker.config.ClockServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clock", url = "${feign.clients.clock.baseUri}", configuration = ClockServiceConfig.class, fallback = ClockClientFallback.class)
public interface ClockClient {

    @GetMapping("/v1/clock/{type}")
    Integer getClockCount(@PathVariable("type") String type);
}