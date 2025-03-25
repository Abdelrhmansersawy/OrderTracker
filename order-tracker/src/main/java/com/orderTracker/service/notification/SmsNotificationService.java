package com.orderTracker.service.notification;
import com.orderTracker.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        // TODO: implement the sms channel logic
    }
}