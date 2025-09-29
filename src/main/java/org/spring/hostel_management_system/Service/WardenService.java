package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.DTO.*;
import org.spring.hostel_management_system.Model.Role;
import org.spring.hostel_management_system.Model.StaffProfile;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Repository.StaffProfileRepo;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static org.spring.hostel_management_system.Util.PasswordUtil.generateRandomPassword;

@Service
public class WardenService {
    private final PasswordEncoder passwordEncoder;
    private final StaffProfileRepo staffProfileRepo;
    private final UserRepo userRepo;

    public WardenService(PasswordEncoder passwordEncoder, StaffProfileRepo staffProfileRepo, UserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.staffProfileRepo = staffProfileRepo;
        this.userRepo = userRepo;
    }

    public List<StudentFullProfileDTO> getAllStudents() {
    }

    public StudentFullProfileDTO getStudentById(String id) {
    }

    public User addWarden(String id, WardenRegisterDTO warden) {
    }

    public StaffFullProfileDTO addStaff(String id, StaffRegisterDTO staffRegisterDTO) {
        return null;
    }

    public List<RoommateScoreDTO> getRoommateScore() {
    }

    public boolean allotRoom(String studentId1, String studentId2, String roomId) {
    }
}
