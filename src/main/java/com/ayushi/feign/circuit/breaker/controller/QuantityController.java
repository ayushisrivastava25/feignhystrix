package com.ayushi.feign.circuit.breaker.controller;

import com.ayushi.feign.circuit.breaker.service.QuantityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuantityController {

    private QuantityService quantityService;

    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @GetMapping("/v1/quantity")
    public ResponseEntity<Integer> getQuantityByType(@RequestParam("type") String type) {
        return ResponseEntity.ok(quantityService.getQuantityByType(type));
    }
}
