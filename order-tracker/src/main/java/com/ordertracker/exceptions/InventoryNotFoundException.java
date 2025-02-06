package com.ordertracker.exceptions;

import org.springframework.http.HttpStatus;

public class InventoryNotFoundException extends RestException {
    
    public InventoryNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
