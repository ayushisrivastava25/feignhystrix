package com.ayushi.feign.circuit.breaker.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
public class StoreClient {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Integer getStores() {
        //do stuff that might fail
        return 10/0;
    }

    public Integer defaultStores() {
        return 0;
    }
}
