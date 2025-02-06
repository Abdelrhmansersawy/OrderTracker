package com.ordertracker.entities.notifications;

public enum NotificationType {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    private String type;
    NotificationType(String type) {
        this.type = type;
    }
}
