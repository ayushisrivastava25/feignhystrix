package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.CompassClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CompassClientFallbackFactory implements FallbackFactory<CompassClient> {

    // access to the cause that made the fallback trigger via FallbackFactory
    @Override
    public CompassClient create(Throwable throwable) {
        return new CompassClientFallback(throwable);
    }
}
