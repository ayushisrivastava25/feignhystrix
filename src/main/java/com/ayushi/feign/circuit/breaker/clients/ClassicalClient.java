package com.ayushi.feign.circuit.breaker.clients;

import com.ayushi.feign.circuit.breaker.clients.fallbacks.ClassicalClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "classical", url = "${feign.clients.helper.baseUri}")
//, fallback = ClassicalClientFallback.class)
public interface ClassicalClient {

    @GetMapping("/v1/classical/{ragaType}")
    Integer getClassicalSongsCount(@PathVariable("ragaType") String ragaType);
}