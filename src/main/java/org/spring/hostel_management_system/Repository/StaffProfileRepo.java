package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.StaffProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffProfileRepo extends MongoRepository<StaffProfile, String>{
    StaffProfile findByUserId(String id);
}
