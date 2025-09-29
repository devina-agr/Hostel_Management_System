package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends MongoRepository<Notification,String> {
}
