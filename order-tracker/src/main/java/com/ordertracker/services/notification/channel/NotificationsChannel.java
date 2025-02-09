package com.ordertracker.services.notification.channel;

import com.ordertracker.entities.notifications.Notification;

public interface NotificationsChannel {
    boolean send(Notification notification);
}
