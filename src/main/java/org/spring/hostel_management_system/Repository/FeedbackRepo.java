package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends MongoRepository<Feedback, String> {
}
