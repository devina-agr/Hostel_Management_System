package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.DTO.StudentFullProfileDTO;
import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Repository.StudentProfileRepo;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final UserRepo userRepo;
    private final StudentProfileRepo studentProfileRepo;

    public StudentService(UserRepo userRepo, StudentProfileRepo studentProfileRepo) {
        this.userRepo = userRepo;
        this.studentProfileRepo = studentProfileRepo;
    }

    public StudentFullProfileDTO getMyProfile(String id) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
        StudentProfile profile=studentProfileRepo.findByStudentId(id).orElse(null);
        StudentFullProfileDTO dto = new StudentFullProfileDTO();

        // basic user info
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setContactNo(user.getContactNo());

        // profile info (may be null)
        if (profile != null) {
            dto.setBranch(profile.getBranch());
            dto.setYear(profile.getYear());
            dto.setGender(profile.getGender());
            dto.setHostelType(profile.getHostelType());
            dto.setParentContactNo(profile.getParentContactNo());
        }
        boolean complete =
                profile != null &&
                        profile.getBranch() != null &&
                        profile.getYear() > 0 &&
                        profile.getGender() != null &&
                        profile.getHostelType() != null &&
                        profile.getParentContactNo() != null;

        dto.setProfileComplete(complete);
        return dto;
    }


    public void deleteUser(String id) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
        studentProfileRepo.findByStudentId(id).ifPresent(profile->studentProfileRepo.deleteByStudentId(id));
        userRepo.delete(user);

    }

    public User getStudentById(String id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
    }
}
