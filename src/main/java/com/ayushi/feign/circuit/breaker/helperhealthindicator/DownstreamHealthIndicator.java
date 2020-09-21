package com.ayushi.feign.circuit.breaker.helperhealthindicator;

import com.ayushi.feign.circuit.breaker.clients.HelperClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;

@Component
public class DownstreamHealthIndicator implements HealthIndicator {

    private HelperClient helperClient;

    public DownstreamHealthIndicator(HelperClient helperClient) {
        this.helperClient = helperClient;
    }

    @Override
    public Health health() {
        JsonNode response = helperClient.getHealth();
        if (response.get("status").asText().equalsIgnoreCase("UP")) {
            return Health.up().build();
        }
        return Health.down().build();
    }
}

//@Component
//public class DownstreamHealthIndicator implements ReactiveHealthIndicator {
//
//    private HelperClient helperClient;
//
//    public DownstreamHealthIndicator(HelperClient helperClient) {
//        this.helperClient = helperClient;
//    }
//
//    @Override
//    public Mono<Health> health() {
//        return checkDownstreamServiceHealth().onErrorResume(
//                ex -> Mono.just(new Health.Builder().down(ex).build())
//        );
//    }
//
//    private Mono<Health> checkDownstreamServiceHealth() {
//        // we could use WebClient to check health reactively
//        JsonNode response = helperClient.getHealth();
//        if (response.get("status").asText().equalsIgnoreCase("UP")) {
//            return Mono.just(Health.up().build());
//        }
//        return Mono.just(new Health.Builder().up().build());
//    }
//}
