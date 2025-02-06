package com.ordertracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VendorNotFoundException extends RestException {
    public VendorNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
