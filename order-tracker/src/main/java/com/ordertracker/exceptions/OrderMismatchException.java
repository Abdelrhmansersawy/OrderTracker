package com.ordertracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderMismatchException extends RestException {
    public OrderMismatchException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
