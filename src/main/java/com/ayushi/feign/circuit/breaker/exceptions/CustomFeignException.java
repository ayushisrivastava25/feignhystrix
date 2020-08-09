package com.ayushi.feign.circuit.breaker.exceptions;

public class CustomFeignException extends RuntimeException {
    public CustomFeignException(String message) {
        super(message);
    }
}