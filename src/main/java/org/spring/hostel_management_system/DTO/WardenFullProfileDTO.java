package org.spring.hostel_management_system.DTO;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Model.WardenProfile;

public class WardenFullProfileDTO {

    private String id;
    private String name;
    private String email;
    private String contactNo;
    private HostelType hostelType;

    public WardenFullProfileDTO(User user, WardenProfile wardenProfile) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.contactNo = user.getContactNo();
        this.hostelType = wardenProfile.getHostelType();
    }
}
