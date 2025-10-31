package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.Model.Notification;
import org.spring.hostel_management_system.Repository.NotificationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepo notificationRepo;

    public NotificationService(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    public List<Notification> getMyNotification(String id) {
        return notificationRepo.findAllByUserId(id);
    }
}
