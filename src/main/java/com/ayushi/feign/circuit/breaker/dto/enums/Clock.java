package com.ayushi.feign.circuit.breaker.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Clock {

    ANALOG(3, "analog"),
    DIGITAL(2, "digital"),
    CUCKOO(5, "cuckoo"),
    PENDULUM(6, "pendulum");

    private int count;
    private String type;
}
