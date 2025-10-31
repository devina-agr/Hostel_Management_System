package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Repository.StudentProfileRepo;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {

    private final StudentProfileRepo studentProfileRepo;
    private final UserRepo userRepo;

    public StudentProfileService(StudentProfileRepo studentProfileRepo, UserRepo userRepo) {
        this.studentProfileRepo = studentProfileRepo;
        this.userRepo = userRepo;
    }

    public StudentProfile getStudentByUserId(String id) {

        return studentProfileRepo.findByStudentId(id).orElse(null);
    }

    public void updateProfile(String id, StudentProfile studentProfile) {
        studentProfile.setStudentId(id);
       studentProfileRepo.save(studentProfile);
    }

    public void deleteProfileByUserId(String id) {
        studentProfileRepo.findByStudentId(id).ifPresent(studentProfile -> studentProfileRepo.deleteByStudentId(id));
    }
}
