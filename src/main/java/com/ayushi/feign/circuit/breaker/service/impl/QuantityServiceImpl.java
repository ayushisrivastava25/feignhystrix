package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.clients.AppliancesClient;
import com.ayushi.feign.circuit.breaker.clients.ClockClient;
import com.ayushi.feign.circuit.breaker.clients.CompassClient;
import com.ayushi.feign.circuit.breaker.dto.QuantityResponse;
import com.ayushi.feign.circuit.breaker.service.QuantityService;

public class QuantityServiceImpl implements QuantityService {

    private ClockClient clockClient;
    private AppliancesClient appliancesClient;
    private CompassClient compassClient;

    public QuantityServiceImpl(ClockClient clockClient, AppliancesClient appliancesClient, CompassClient compassClient) {
        this.clockClient = clockClient;
        this.appliancesClient = appliancesClient;
        this.compassClient = compassClient;
    }

    @Override
    public QuantityResponse getQuantityByType(String type) {
        return QuantityResponse.builder().clock(clockClient.getClockCount(type)).appliance(appliancesClient.getApplianceCount()).compass(compassClient.getCompassCount()).build();
    }
}
