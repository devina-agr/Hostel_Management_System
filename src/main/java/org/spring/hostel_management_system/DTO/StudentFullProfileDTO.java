package org.spring.hostel_management_system.DTO;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Preference;
import org.spring.hostel_management_system.Model.Role;

import java.util.Set;

public class StudentFullProfileDTO {

    private String id;
    private String name;
    private String email;
    private Set<Role> role;
    private String contactNo;
    private String branch;
    private int year;
    private String gender;
    private HostelType hostelType;
    private String roomId;
    private String parentContactNo;
    private Preference preference;

    public StudentFullProfileDTO(String id, String name, String email,Set<Role> role, String contactNo, String branch, int year, String gender, HostelType hostelType, String roomId, String parentContactNo, Preference preference) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.contactNo = contactNo;
        this.branch = branch;
        this.year = year;
        this.gender = gender;
        this.hostelType = hostelType;
        this.roomId = roomId;
        this.parentContactNo = parentContactNo;
        this.preference = preference;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HostelType getHostelType() {
        return hostelType;
    }

    public void setHostelType(HostelType hostelType) {
        this.hostelType = hostelType;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getParentContactNo() {
        return parentContactNo;
    }

    public void setParentContactNo(String parentContactNo) {
        this.parentContactNo = parentContactNo;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }
}
