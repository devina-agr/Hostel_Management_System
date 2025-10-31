package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends MongoRepository<Notification,String> {
    List<Notification> findAllByUserId(String id);
}
