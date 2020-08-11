package com.ayushi.feign.circuit.breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients(basePackages = "com.ayushi")
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@Import({ApiConfiguration.class})
public class FeignCircuitBreakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignCircuitBreakerApplication.class, args);
    }
}
