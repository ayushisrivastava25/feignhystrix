package com.ayushi.feign.circuit.breaker;

import com.ayushi.feign.circuit.breaker.clients.FolkClient;
import com.ayushi.feign.circuit.breaker.clients.ClassicalClient;
import com.ayushi.feign.circuit.breaker.clients.FusionClient;
import com.ayushi.feign.circuit.breaker.service.ClassicalClientService;
import com.ayushi.feign.circuit.breaker.service.FolkClientService;
import com.ayushi.feign.circuit.breaker.service.FusionClientService;
import com.ayushi.feign.circuit.breaker.service.SongsService;
import com.ayushi.feign.circuit.breaker.service.impl.ClassicalClientServiceImpl;
import com.ayushi.feign.circuit.breaker.service.impl.FolkClientServiceImpl;
import com.ayushi.feign.circuit.breaker.service.impl.FusionClientServiceImpl;
import com.ayushi.feign.circuit.breaker.service.impl.SongsServiceImpl;
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
    public SongsService songsService(ClassicalClientService classicalClientService, FolkClientService folkClientService, FusionClientService fusionClientService) {
        return new SongsServiceImpl(classicalClientService, folkClientService, fusionClientService);
    }

    @Bean
    public ClassicalClientService classicalClientService(ClassicalClient classicalClient) {
        return new ClassicalClientServiceImpl(classicalClient);
    }

    @Bean
    public FusionClientService fusionClientService(FusionClient fusionClient) {
        return new FusionClientServiceImpl(fusionClient);
    }

    @Bean
    public FolkClientService folkClientService(FolkClient folkClient) {
        return new FolkClientServiceImpl(folkClient);
    }
}
