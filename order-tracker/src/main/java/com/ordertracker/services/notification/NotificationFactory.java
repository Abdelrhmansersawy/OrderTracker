package com.ordertracker.services.notification;

import com.ordertracker.entities.notifications.NotificationType;
import com.ordertracker.services.notification.channel.NotificationsChannel;
import com.ordertracker.services.notification.channel.EmailChannel;
import com.ordertracker.services.notification.channel.PUSHChannel;
import com.ordertracker.services.notification.channel.SMSChannel;

public class NotificationFactory {
    public static NotificationsChannel getNotificationsChannel(NotificationType notificationType) {
        return switch (notificationType) {
            case EMAIL -> new EmailChannel();
            case SMS -> new SMSChannel();
            case PUSH -> new PUSHChannel();
        };
    }
}
