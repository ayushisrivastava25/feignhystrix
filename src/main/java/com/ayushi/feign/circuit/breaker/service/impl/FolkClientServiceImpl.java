package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.clients.ClassicalClient;
import com.ayushi.feign.circuit.breaker.clients.FolkClient;
import com.ayushi.feign.circuit.breaker.service.FolkClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FolkClientServiceImpl implements FolkClientService {

    private FolkClient folkClient;

    public FolkClientServiceImpl(FolkClient folkClient) {
        this.folkClient = folkClient;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFolkSongsFallbackCount", commandKey = "songsKey", threadPoolKey = "songsPool")
    public Integer getFolkSongsCount() {
        return folkClient.getFolkSongsCount();
    }

    public Integer getFolkSongsFallbackCount() {
        log.info("fallback in folk client call" );
        return 10;
    }
}
