package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.clients.ClockClient;
import com.ayushi.feign.circuit.breaker.service.QuantityService;

//@Service
public class QuantityServiceImpl implements QuantityService {

    private ClockClient clockClient;

    public QuantityServiceImpl(ClockClient clockClient) {
        this.clockClient = clockClient;
    }

    @Override
    public Integer getQuantityByType(String type) {
        return clockClient.getClockCount(type);
    }
}
