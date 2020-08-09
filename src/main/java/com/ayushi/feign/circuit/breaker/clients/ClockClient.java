package com.ayushi.feign.circuit.breaker.clients;

import com.ayushi.feign.circuit.breaker.config.ClockServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clock", url = "${feign.clients.clock.baseUri}", configuration = ClockServiceConfig.class, fallbackFactory = ClockClientFallback2.class)
//        , fallback = ClockClientFallbackFactory.class)
public interface ClockClient {

    @GetMapping("/v1/{type}")
    Integer getClockCount(@PathVariable("type") String type);
}