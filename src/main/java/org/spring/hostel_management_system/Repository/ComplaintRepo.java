package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepo extends MongoRepository<Complaint, String> {
    List<Complaint> findAllByStudentId(String id);
}
