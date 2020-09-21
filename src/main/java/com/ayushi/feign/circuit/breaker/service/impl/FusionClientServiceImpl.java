package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.clients.ClassicalClient;
import com.ayushi.feign.circuit.breaker.clients.FusionClient;
import com.ayushi.feign.circuit.breaker.service.FusionClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FusionClientServiceImpl implements FusionClientService {

    private FusionClient fusionClient;

    public FusionClientServiceImpl(FusionClient fusionClient) {
        this.fusionClient = fusionClient;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFusionSongsFallbackCount", commandKey = "songsKey", threadPoolKey = "songsPool")
    public Integer getFusionSongsCount() {
        return fusionClient.getFusionSongsCount();
    }

    public Integer getFusionSongsFallbackCount() {
        log.info("fallback in fusion client call" );
        return 10;
    }
}
