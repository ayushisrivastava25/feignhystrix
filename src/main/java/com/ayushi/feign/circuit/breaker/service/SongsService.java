package com.ayushi.feign.circuit.breaker.service;

import com.ayushi.feign.circuit.breaker.dto.SongsCountResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface SongsService {

    SongsCountResponse getSongsCountByType(String type);
}
