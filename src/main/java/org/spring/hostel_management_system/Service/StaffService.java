package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.DTO.StaffFullProfileDTO;
import org.spring.hostel_management_system.Model.StaffProfile;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Repository.StaffProfileRepo;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final UserRepo userRepo;
    private final StaffProfileRepo staffProfileRepo;
    private final PasswordEncoder passwordEncoder;

    public StaffService(UserRepo userRepo, StaffProfileRepo staffProfileRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.staffProfileRepo = staffProfileRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public StaffFullProfileDTO getProfile(String id) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
        StaffProfile staffProfile=staffProfileRepo.findByUserId(id);
        return new StaffFullProfileDTO(user, staffProfile);
    }

    public User getStaffById(String id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("No user found!"));
    }

    public StaffFullProfileDTO updateProfile(String id, StaffProfile staffProfile) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
        StaffProfile profile=staffProfileRepo.findByUserId(id);
        if(profile==null){
            profile=new StaffProfile();
            profile.setUserId(id);
        }
        if(staffProfile.getShift()!=null){
            profile.setShift(staffProfile.getShift());
        }
        if(staffProfile.getHostelType()!=null){
            profile.setHostelType(staffProfile.getHostelType());
        }
        if(staffProfile.getDepartment()!=null){
            profile.setDepartment(staffProfile.getDepartment());
        }
        profile.setUserId(id);
        staffProfileRepo.save(profile);
        return new StaffFullProfileDTO(user,profile);
    }

    public void updatePassword(String id, String oldPassword, String newPassword) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        if(!passwordEncoder.matches(oldPassword,user.getPassword())){
            throw new RuntimeException("Incorrect password");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
    }
}
