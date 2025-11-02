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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public HostelType getHostelType() {
        return hostelType;
    }

    public void setHostelType(HostelType hostelType) {
        this.hostelType = hostelType;
    }

    public WardenFullProfileDTO(User user, WardenProfile wardenProfile) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.contactNo = user.getContactNo();
        this.hostelType = wardenProfile.getHostelType();
    }
}
