package com.ayushi.feign.circuit.breaker.service.impl;

import com.ayushi.feign.circuit.breaker.clients.FolkClient;
import com.ayushi.feign.circuit.breaker.clients.ClassicalClient;
import com.ayushi.feign.circuit.breaker.clients.FusionClient;
import com.ayushi.feign.circuit.breaker.clients.fallbacks.ClassicalClientFallback;
import com.ayushi.feign.circuit.breaker.dto.SongsCountResponse;
import com.ayushi.feign.circuit.breaker.service.ClassicalClientService;
import com.ayushi.feign.circuit.breaker.service.FolkClientService;
import com.ayushi.feign.circuit.breaker.service.FusionClientService;
import com.ayushi.feign.circuit.breaker.service.SongsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
public class SongsServiceImpl implements SongsService {

    private ClassicalClientService classicalClientService;
    private FolkClientService folkClientService;
    private FusionClientService fusionClientService;

    public SongsServiceImpl(ClassicalClientService classicalClientService, FolkClientService folkClientService, FusionClientService fusionClientService) {
        this.classicalClientService = classicalClientService;
        this.folkClientService = folkClientService;
        this.fusionClientService = fusionClientService;
    }

    @Override
//    @HystrixCommand(fallbackMethod = "getClassicalSongsFallbackCount", commandKey = "disposeKey", threadPoolKey = "disposePool")
    public SongsCountResponse getSongsCountByType(String type) {
//        return new AsyncResult<SongsCountResponse>() {
//            @Override
//            public SongsCountResponse invoke() {
//                int classicalCount = 0, folkCount=0, fusionCount=0;
//                try {
//                    classicalCount = classicalClient.getClassicalSongsCount(type);
//                    folkCount = folkClient.getFolkSongsCount();
//                    fusionCount = fusionClient.getFusionSongsCount();
//                } catch (Exception e) {
//                    log.error("exception");
//                }
//                return SongsCountResponse.builder().classical(classicalCount).folk(folkCount).fusion(fusionCount).build();
//            }
//        };
//        SongsCountResponse songsCountResponse = new SongsCountResponse();
//        try {
////            Thread.sleep(2000);
//            songsCountResponse =
//        } catch (Exception e) {
//            log.error("error occurred : {}", e.getMessage());
//        }
        return SongsCountResponse.builder().classical(classicalClientService.getClassicalSongsCount(type))
                .folk(folkClientService.getFolkSongsCount()).fusion(fusionClientService.getFusionSongsCount())
                .build();
//        return SongsCountResponse.builder().classical(classicalClient.getClassicalSongsCount(type)).folk(folkClient.getFolkSongsCount()).fusion(fusionClient.getFusionSongsCount()).build();
//        return CompletableFuture.supplyAsync(
//                () -> {
//                    return SongsCountResponse.builder().classical(classicalClient.getClassicalSongsCount(type)).folk(folkClient.getFolkSongsCount()).fusion(fusionClient.getFusionSongsCount()).build();
//                });
    }
}
