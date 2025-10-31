package org.spring.hostel_management_system.Repository;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends MongoRepository<Menu, String> {
    List<Menu> findByHostelType(HostelType hostelType);
}
