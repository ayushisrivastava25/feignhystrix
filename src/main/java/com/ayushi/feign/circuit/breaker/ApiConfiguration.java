package com.ayushi.feign.circuit.breaker;

import com.ayushi.feign.circuit.breaker.clients.AppliancesClient;
import com.ayushi.feign.circuit.breaker.clients.ClockClient;
import com.ayushi.feign.circuit.breaker.clients.CompassClient;
import com.ayushi.feign.circuit.breaker.clients.StoreClient;
import com.ayushi.feign.circuit.breaker.service.ApplianceService;
import com.ayushi.feign.circuit.breaker.service.ClockService;
import com.ayushi.feign.circuit.breaker.service.CompassService;
import com.ayushi.feign.circuit.breaker.service.QuantityService;
import com.ayushi.feign.circuit.breaker.service.impl.ApplianceServiceImpl;
import com.ayushi.feign.circuit.breaker.service.impl.ClockServiceImpl;
import com.ayushi.feign.circuit.breaker.service.impl.CompassServiceImpl;
import com.ayushi.feign.circuit.breaker.service.impl.QuantityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {
                "com.ayushi.feign.circuit.breaker.controller",
                "com.ayushi.feign.circuit.breaker.clients"
        })
public class ApiConfiguration {

    @Bean
    public ClockService clockService() {
        return new ClockServiceImpl();
    }

    @Bean
    public ApplianceService applianceService() {
        return new ApplianceServiceImpl();
    }

    @Bean
    public CompassService compassService() {
        return new CompassServiceImpl();
    }

    @Bean
    public QuantityService quantityService(ClockClient clockClient, AppliancesClient appliancesClient, CompassClient compassClient) {
        return new QuantityServiceImpl(clockClient, appliancesClient, compassClient);
    }
}
