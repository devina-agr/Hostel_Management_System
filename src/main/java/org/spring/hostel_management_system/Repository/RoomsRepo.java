package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Rooms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepo extends MongoRepository<Rooms, String> {

    List<Rooms> findAllByBookedFalseAndHostelTypeAndBlock(HostelType hostelType, String block);
}
