package com.ayushi.feign.circuit.breaker.clients;

import com.ayushi.feign.circuit.breaker.clients.fallbacks.ApplianceClientFallback;
import com.ayushi.feign.circuit.breaker.config.ClockServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "application", url = "${feign.clients.clock.baseUri}", configuration = ClockServiceConfig.class, fallbackFactory = ApplianceClientFallback.class)
public interface AppliancesClient {

    @GetMapping("/v1/appliance")
    Integer getApplianceCount();
}
