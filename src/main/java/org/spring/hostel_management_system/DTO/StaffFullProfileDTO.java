package org.spring.hostel_management_system.DTO;

import org.spring.hostel_management_system.Model.Role;
import org.spring.hostel_management_system.Model.StaffProfile;
import org.spring.hostel_management_system.Model.User;

import java.util.Set;

public class StaffFullProfileDTO {

    private String id;
    private String name;
    private String email;
    private Set<Role> role;
    private String contactNo;
    private String department;
    private String shift;

    public StaffFullProfileDTO(User staff, StaffProfile staffProfile) {
        this.id=staff.getId();
        this.name=staff.getName();
        this.email=staff.getEmail();
        this.role=staff.getRole();
        this.contactNo=staff.getContactNo();
        this.department=staffProfile.getDepartment();
        this.shift=staffProfile.getShift();
    }

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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
