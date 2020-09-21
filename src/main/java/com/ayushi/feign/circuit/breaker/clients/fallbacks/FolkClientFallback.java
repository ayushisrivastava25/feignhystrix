package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.FolkClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FolkClientFallback implements FallbackFactory<FolkClient> {

    // sample use of FallbackFactory
    @Override
    public FolkClient create(Throwable cause) {
        return new FolkClient() {
            @Override
            public Integer getFolkSongsCount() {
                log.info("fallback in folk client call ; reason was: " + cause.getMessage());
                return 10;
            }
        };
    }
}