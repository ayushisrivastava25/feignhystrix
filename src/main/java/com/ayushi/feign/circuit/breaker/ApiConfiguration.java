package com.ayushi.feign.circuit.breaker;

import com.ayushi.feign.circuit.breaker.clients.ClockClient;
import com.ayushi.feign.circuit.breaker.service.ClockService;
import com.ayushi.feign.circuit.breaker.service.QuantityService;
import com.ayushi.feign.circuit.breaker.service.impl.ClockServiceImpl;
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
    public QuantityService quantityService(ClockClient clockClient) {
        return new QuantityServiceImpl(clockClient);
    }
}
