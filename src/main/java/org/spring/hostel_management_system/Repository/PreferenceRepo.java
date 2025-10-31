package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreferenceRepo extends MongoRepository<Preference, String> {
    Optional<Preference> findByStudentId(String id);
}
