package com.ayushi.feign.circuit.breaker.controller.advice;

import com.ayushi.feign.circuit.breaker.exceptions.CustomFeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseControllerAdvice {

//    @ExceptionHandler({CustomFeignException.class})
//    public ResponseEntity<FailureResponse> handleCustomFeignException(
//            CustomFeignException exception) {
//        FailureResponse failureResponse =
//                new FailureResponse(
//                        exception.getMessage(), HttpStatus.NOT_FOUND.value());
//        return ResponseEntity.ok(failureResponse);
//    }
}
