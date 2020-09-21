package com.ayushi.feign.circuit.breaker.clients;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "helper", url = "${feign.clients.helper.baseUri}")
public interface HelperClient {

    @GetMapping("/actuator/health")
    JsonNode getHealth();
}
