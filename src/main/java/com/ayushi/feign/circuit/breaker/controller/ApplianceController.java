package com.ayushi.feign.circuit.breaker.controller;

import com.ayushi.feign.circuit.breaker.service.ApplianceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplianceController {

    private ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @GetMapping("/v1/appliance")
    public ResponseEntity<Integer> getApplianceCount() {
        return ResponseEntity.ok(applianceService.getApplianceCount());
    }
}
