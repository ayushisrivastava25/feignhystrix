package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.FusionClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FusionClientFallbackFactory implements FallbackFactory<FusionClient> {

    // access to the cause that made the fallback trigger via FallbackFactory
    @Override
    public FusionClient create(Throwable throwable) {
        return new FusionClientFallback(throwable);
    }
}
