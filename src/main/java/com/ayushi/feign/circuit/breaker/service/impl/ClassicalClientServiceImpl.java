package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.SongsCommand;
import com.ayushi.feign.circuit.breaker.clients.ClassicalClient;
import com.ayushi.feign.circuit.breaker.dto.SongsCountResponse;
import com.ayushi.feign.circuit.breaker.service.ClassicalClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassicalClientServiceImpl implements ClassicalClientService {

    private ClassicalClient classicalClient;

    public ClassicalClientServiceImpl(ClassicalClient classicalClient) {
        this.classicalClient = classicalClient;
    }

//    @Override
//    @HystrixCommand(fallbackMethod = "getClassicalSongsFallbackCount", commandKey = "classicalKey", threadPoolKey = "songsPool",  commandProperties = {
//            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
//    })
//    public Integer getClassicalSongsCount(String type) {
//        return classicalClient.getClassicalSongsCount(type);
//    }
//
//    public Integer getClassicalSongsFallbackCount(String type) {
//        log.info("fallback in classical client call" );
//        return 10;
//    }

    public Integer getClassicalSongsCount(String type) {
        SongsCommand songsCommand = new SongsCommand(type, classicalClient);
        return songsCommand.observe().toBlocking().single();
    }
}