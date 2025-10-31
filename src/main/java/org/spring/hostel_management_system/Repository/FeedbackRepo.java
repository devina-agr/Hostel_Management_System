package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepo extends MongoRepository<Feedback, String> {
    List<Feedback> findAllByStudentId(String id);
}
