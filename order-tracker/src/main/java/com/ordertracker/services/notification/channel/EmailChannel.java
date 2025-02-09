package com.ordertracker.services.notification.channel;
import com.ordertracker.entities.notifications.Notification;

public class EmailChannel implements NotificationsChannel {
    @Override
    public boolean send(Notification notification) {
        // TODO: implement the email channel logic
        return false;
    }
}