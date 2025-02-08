package com.ordertracker.services.notifications.channel;

import com.ordertracker.entities.notifications.Notification;

public class PUSHChannel implements NotificationsChannel{

    @Override
    public boolean send(Notification notification) {
        // TODO: Implement push sending logic
        return false;
    }
}
