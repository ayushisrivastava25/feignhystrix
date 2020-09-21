package com.ayushi.feign.circuit.breaker.controller;

import com.ayushi.feign.circuit.breaker.dto.SongsCountResponse;
import com.ayushi.feign.circuit.breaker.service.SongsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class SongsController {

    private SongsService songsService;

    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }

//    @HystrixCommand
    @GetMapping("/v1/songs")
    public ResponseEntity<SongsCountResponse> getSongsCountByType(@RequestParam("ragaType") String type) {
//        return ResponseEntity.ok(CompletableFuture.allOf(songsService.getSongsCountByType(type)).join());
        return ResponseEntity.ok(songsService.getSongsCountByType(type));
    }
}
