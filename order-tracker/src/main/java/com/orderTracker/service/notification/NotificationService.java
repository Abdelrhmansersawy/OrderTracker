package com.orderTracker.service.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Service
public class NotificationService {
    private final BlockingQueue<NotificationEvent> notificationQueue;

    @Autowired
    public notificationervice(BlockingQueue<NotificationEvent> notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public void notifyObservers(Order order) {
        notificationQueue.add(new NotificationEvent(order));
    }
}
