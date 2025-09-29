package org.spring.hostel_management_system.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends MongoRepository<MenuRepo, String> {
}
