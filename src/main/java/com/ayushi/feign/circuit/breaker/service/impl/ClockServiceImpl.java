package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.dto.enums.Clock;
import com.ayushi.feign.circuit.breaker.service.ClockService;

import java.util.Arrays;

//@Service
public class ClockServiceImpl implements ClockService {

    public ClockServiceImpl() {
    }

    public Integer getClockCount(final String type) {
        Clock clock =
                Arrays.asList(Clock.values()).stream()
                        .filter(
                                clockDetails ->
                                        (clockDetails.getType().equals(type)))
                        .findFirst()
                        .orElse(null);
        return clock.getCount();
    }
}
