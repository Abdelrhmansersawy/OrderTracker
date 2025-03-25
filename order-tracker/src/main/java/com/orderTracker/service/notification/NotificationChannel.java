package com.orderTracker.service.notification;

import com.orderTracker.entity.Notification;

public interface NotificationChannel {
    void send(Notification notification);
}
