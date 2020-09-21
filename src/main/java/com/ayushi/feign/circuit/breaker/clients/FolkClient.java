package com.ayushi.feign.circuit.breaker.clients;

import com.ayushi.feign.circuit.breaker.clients.fallbacks.FolkClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "folk", url = "${feign.clients.helper.baseUri}")
//, fallbackFactory = FolkClientFallback.class)
public interface FolkClient {

    @GetMapping("/v1/folk")
    Integer getFolkSongsCount();
}
