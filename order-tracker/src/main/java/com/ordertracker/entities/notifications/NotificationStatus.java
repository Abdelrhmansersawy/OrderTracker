package com.ordertracker.entities.notifications;

public enum NotificationStatus {
    PENDING("pending"),
    SENT("sent"),
    FAILED("failed"),
    READ("read");

    private String status;
    NotificationStatus(String status) {
        this.status = status;
    }
}
