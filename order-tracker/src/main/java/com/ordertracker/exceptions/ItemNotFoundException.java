package com.ordertracker.exceptions;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends RestException {
    
    public ItemNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
