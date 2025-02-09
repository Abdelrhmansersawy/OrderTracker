package com.ordertracker.services.notification.channel;
import com.ordertracker.entities.notifications.Notification;

public class PUSHChannel implements NotificationsChannel {

    @Override
    public boolean send(Notification notification) {
        // TODO: implement the push channel logic
        return false;
    }
}
