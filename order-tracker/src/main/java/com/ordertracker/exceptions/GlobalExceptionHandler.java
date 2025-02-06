package com.ordertracker.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<String> handleRestExceptions(RestException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }
}
