package com.ayushi.feign.circuit.breaker.service;

public interface ClockService {

    Integer getClockCount(String type);
}
