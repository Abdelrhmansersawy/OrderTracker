package com.ordertracker.services.notifications.channel;

import com.ordertracker.entities.notifications.Notification;

public interface NotificationsChannel {
    public boolean send(Notification notification);

}
