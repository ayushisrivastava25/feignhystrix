package com.ayushi.feign.circuit.breaker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongsCountResponse {

    @JsonProperty("classical")
    private Integer classical;
    @JsonProperty("folk")
    private Integer folk;
    @JsonProperty("fusion")
    private Integer fusion;
}
