package com.ayushi.feign.circuit.breaker;

//import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients(basePackages = "com.ayushi")
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
//@EnableTurbine // for aggregating multiple streams into a single stream
@EnableDiscoveryClient
@EnableEurekaClient
@Import({ApiConfiguration.class})
public class FeignCircuitBreakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignCircuitBreakerApplication.class, args);
    }
}
