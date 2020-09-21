package com.ayushi.feign.circuit.breaker.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/health")
public class HealthController {

    @GetMapping
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok().body("OK");
    }
}
