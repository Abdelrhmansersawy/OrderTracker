package com.ordertracker.services.notification.channel;
import com.ordertracker.entities.notifications.Notification;

public class SMSChannel implements NotificationsChannel {
    @Override
    public boolean send(Notification notification) {
        // TODO: implement the sms channel logic
        return false;
    }
}