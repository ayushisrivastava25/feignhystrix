package com.ayushi.feign.circuit.breaker.controller;

import com.ayushi.feign.circuit.breaker.service.ClockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockController {

    private ClockService clockService;

    public ClockController(ClockService clockService) {
        this.clockService = clockService;
    }

    @GetMapping("/v1/clock/{type}")
    public ResponseEntity<Integer> getClockCount(@PathVariable("type") String type) {
        return ResponseEntity.ok(clockService.getClockCount(type));
    }
}
