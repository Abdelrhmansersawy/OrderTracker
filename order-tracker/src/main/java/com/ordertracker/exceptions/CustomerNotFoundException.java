package com.ordertracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RestException {
    public CustomerNotFoundException(String message) {
      super(message, HttpStatus.NOT_FOUND);
    }
}
