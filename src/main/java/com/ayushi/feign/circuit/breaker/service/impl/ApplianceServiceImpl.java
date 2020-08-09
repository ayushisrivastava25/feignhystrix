package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.service.ApplianceService;

public class ApplianceServiceImpl implements ApplianceService {

    public ApplianceServiceImpl() {
    }

    public Integer getApplianceCount() {
        return 10;
    }
}
