package com.orderTracker.service.notification;

import com.orderTracker.enums.NotificationType;

public class NotificationFactory {
    public static NotificationChannel getnotificationChannel(NotificationType notificationType) {
        return switch (notificationType) {
            case EMAIL -> new EmailNotificationService();
            case SMS -> new SmsNotificationService();
            case PUSH -> new PushNotificationService();
        };
    }
}
