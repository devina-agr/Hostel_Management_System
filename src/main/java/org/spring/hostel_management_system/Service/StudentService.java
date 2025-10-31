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
        StudentProfile studentProfile=studentProfileRepo.findByStudentId(id).orElse(null);
        return new StudentFullProfileDTO(user, studentProfile);
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
