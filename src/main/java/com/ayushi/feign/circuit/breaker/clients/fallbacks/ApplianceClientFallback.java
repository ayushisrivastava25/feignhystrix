package com.ayushi.feign.circuit.breaker.clients.fallbacks;

import com.ayushi.feign.circuit.breaker.clients.AppliancesClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplianceClientFallback implements FallbackFactory<AppliancesClient> {

    // sample use of FallbackFactory
    @Override
    public AppliancesClient create(Throwable cause) {
        return new AppliancesClient() {
            @Override
            public Integer getApplianceCount() {
                log.info("fallback in appliance call ; reason was: " + cause.getMessage());
                return 10;
            }
        };
    }
}