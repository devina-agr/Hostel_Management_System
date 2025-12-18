package org.spring.hostel_management_system.DTO;

import org.spring.hostel_management_system.Model.*;

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
    private boolean profileComplete=false;

    public StudentFullProfileDTO() {

    }

    public StudentFullProfileDTO(User user, StudentProfile profile) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.contactNo = user.getContactNo();

        if (profile != null) {
            this.branch = profile.getBranch();
            this.year = profile.getYear();
            this.gender = profile.getGender();
            this.hostelType = profile.getHostelType();
            this.roomId = profile.getRoomId();
            this.parentContactNo = profile.getParentContactNo();
            this.preference = profile.getPreference();
        }
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

    public boolean isProfileComplete() {
        return profileComplete;
    }

    public void setProfileComplete(boolean profileComplete) {
        this.profileComplete = profileComplete;
    }
}
