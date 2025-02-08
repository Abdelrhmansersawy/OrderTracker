package com.ordertracker.services.notifications.channel;

import com.ordertracker.entities.notifications.Notification;

public class SMSChannel implements NotificationsChannel{
    @Override
    public boolean send(Notification notification) {
        // TODO: Implement sms sending logic
        return false;
    }
}
