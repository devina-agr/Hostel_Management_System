package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Model.WardenProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardenProfileRepo extends MongoRepository<WardenProfile, String> {
    WardenProfile findByUserId(String userId);
}
