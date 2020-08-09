package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.service.CompassService;

public class CompassServiceImpl implements CompassService {

    public CompassServiceImpl() {
    }

    public Integer getCompassCount() {
        return 4;
    }
}
