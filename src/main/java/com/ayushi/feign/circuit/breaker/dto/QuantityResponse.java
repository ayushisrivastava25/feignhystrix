package com.ayushi.feign.circuit.breaker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class QuantityResponse {

    @JsonProperty("clock")
    private Integer clock;
    @JsonProperty("appliance")
    private Integer appliance;
    @JsonProperty("compass")
    private Integer compass;
}
