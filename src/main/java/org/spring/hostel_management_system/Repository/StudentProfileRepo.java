package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.StudentProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentProfileRepo extends MongoRepository<StudentProfile, String> {
    Optional<StudentProfile> findByStudentId(String id);

    void deleteByStudentId(String id);
}
