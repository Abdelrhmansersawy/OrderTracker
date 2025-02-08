package com.ordertracker.services.notifications.channel;

import com.ordertracker.entities.notifications.Notification;

import java.nio.channels.Channel;

public class EmailChannel implements NotificationsChannel {
    @Override
    public boolean send(Notification notification) {
        // TODO: Implement email sending logic
        return false;
    }
}
