package com.ayushi.feign.circuit.breaker.clients;

import com.ayushi.feign.circuit.breaker.clients.fallbacks.FusionClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "fusion", url = "${feign.clients.helper.baseUri}")
//, fallbackFactory = FusionClientFallbackFactory.class)
public interface FusionClient {

    @GetMapping("/v1/fusion")
    Integer getFusionSongsCount();
}
