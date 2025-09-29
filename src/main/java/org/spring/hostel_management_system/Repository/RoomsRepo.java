package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.Rooms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepo extends MongoRepository<Rooms, String> {
}
