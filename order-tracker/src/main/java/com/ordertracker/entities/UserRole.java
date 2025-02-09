package com.ordertracker.entities;

public enum UserRole {
    ADMIN("admin"),
    CUSTOMER("customer"),
    VENDOR("vendor");

    private String role;
    UserRole(String role){
        this.role = role;
    }
}
