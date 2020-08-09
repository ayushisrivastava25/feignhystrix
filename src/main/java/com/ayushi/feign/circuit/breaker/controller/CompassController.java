package com.ayushi.feign.circuit.breaker.controller;

import com.ayushi.feign.circuit.breaker.service.CompassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompassController {


    private CompassService compassService;

    public CompassController(CompassService compassService) {
        this.compassService = compassService;
    }

    @GetMapping("/v1/compass")
    public ResponseEntity<Integer> getCompassCount() {
        return ResponseEntity.ok(compassService.getCompassCount());
    }
}
