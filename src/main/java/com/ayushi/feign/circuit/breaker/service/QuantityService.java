package com.ayushi.feign.circuit.breaker.service;

import com.ayushi.feign.circuit.breaker.dto.QuantityResponse;

public interface QuantityService {

    QuantityResponse getQuantityByType(String type);
}
