package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.Controller.WardenController;
import org.spring.hostel_management_system.DTO.*;
import org.spring.hostel_management_system.Model.*;
import org.spring.hostel_management_system.Repository.StaffProfileRepo;
import org.spring.hostel_management_system.Repository.StudentProfileRepo;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.spring.hostel_management_system.Repository.WardenProfileRepo;
import org.spring.hostel_management_system.Util.StudentMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.spring.hostel_management_system.Util.PasswordUtil.generateRandomPassword;

@Service
public class WardenService {
    private final PasswordEncoder passwordEncoder;
    private final StaffProfileRepo staffProfileRepo;
    private final UserRepo userRepo;
    private final StudentService studentService;
    private final StudentProfileRepo studentProfileRepo;
    private final StudentMapper studentMapper;
    private final WardenProfileRepo wardenProfileRepo;
    private final EmailService emailService;
    private WardenProfileRepo wardenProfileRepo1;

    public WardenService(PasswordEncoder passwordEncoder, StaffProfileRepo staffProfileRepo, UserRepo userRepo, StudentService studentService, StudentProfileRepo studentProfileRepo, StudentMapper studentMapper, WardenProfileRepo wardenProfileRepo, EmailService emailService) {
        this.passwordEncoder = passwordEncoder;
        this.staffProfileRepo = staffProfileRepo;
        this.userRepo = userRepo;
        this.studentService = studentService;
        this.studentProfileRepo = studentProfileRepo;
        this.studentMapper = studentMapper;
        this.wardenProfileRepo = wardenProfileRepo;
        this.emailService = emailService;
    }

    public List<StudentFullProfileDTO> getAllStudents() {
        List<User> student=userRepo.findAll().stream().filter(user -> user.getRole().contains(Role.ROLE_STUDENT)).toList();

        return student.stream().map(user -> {
            StudentProfile studentProfile=studentProfileRepo.findByStudentId(user.getId()).orElse(null);
            return  studentMapper.toFullDTO(user,studentProfile);
        }).toList();

    }

    public StudentFullProfileDTO getStudentById(String id) {
        User user =userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
        StudentProfile studentProfile=studentProfileRepo.findByStudentId(id).orElse(null);
        return studentMapper.toFullDTO(user,studentProfile);
    }

    public WardenFullProfileDTO addWarden(String id, WardenRegisterDTO warden) {
        User admin=userRepo.findById(id).orElseThrow(()->new RuntimeException("Warden not found!"));
            if(admin.getRole().contains(Role.ROLE_WARDEN)){
            String rawPassword=generateRandomPassword();
            User user=new User();
            user.setName(warden.getName());
            user.setEmail(warden.getEmail());
            user.setRole(Set.of(Role.ROLE_WARDEN));
            user.setPassword(passwordEncoder.encode(rawPassword));
            userRepo.save(user);

            WardenProfile wardenProfile=new WardenProfile();
            wardenProfile.setUserId(user.getId());
            wardenProfile.setHostelType(warden.getHostelType());
            wardenProfileRepo.save(wardenProfile);

            String subject="Your Hostel Management System Account";
            String body="Hello " + warden.getName() +",\n\n"
                    +"Your warden account has been created successfully.\n"
                    +"Email: "+warden.getEmail()+"\n"
                    +"Temporary Password: " + rawPassword + "\n\n"
                    + "Please log in and change your password after first login.\n\n"
                    + "Regards,\nHostel Management System";

            emailService.sendEmail(warden.getEmail(),subject,body);

            return new WardenFullProfileDTO(user,wardenProfile);
        }
        else{
            throw new RuntimeException("Access denied!");
        }
    }

    public StaffFullProfileDTO addStaff(String id, StaffRegisterDTO staffRegisterDTO) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("Warden not found!"));
        if(user.getRole().contains(Role.ROLE_WARDEN)){
            String rawPassword=generateRandomPassword();
            User staff=new User();
            staff.setName(staffRegisterDTO.getName());
            staff.setEmail(staffRegisterDTO.getEmail());
            staff.setPassword(passwordEncoder.encode(rawPassword));
            staff.setRole(Set.of(Role.ROLE_STAFF));
            StaffProfile staffProfile=new StaffProfile();
            staffProfile.setHostelType(staffRegisterDTO.getHostelType());
            staffProfile.setDepartment(staffRegisterDTO.getDept());
            staffProfile.setShift(staffRegisterDTO.getShift());
            userRepo.save(staff);
            staffProfileRepo.save(staffProfile);
            String subject="Your Hostel Management System Account";
            String body="Hello" + staffRegisterDTO.getName() +",\n\n"
                    +"Your staff account has been created successfully.\n"
                    +"Email: "+staffRegisterDTO.getEmail()+"\n"
                    +"Temporary Password: " + rawPassword + "\n\n"
                    + "Please log in and change your password after first login.\n\n"
                    + "Regards,\nHostel Management System";

            emailService.sendEmail(staffRegisterDTO.getEmail(),subject,body);
            return new StaffFullProfileDTO(staff,staffProfile);
        }
        else{
            throw new RuntimeException("Access Denied!");
        }
    }

//    public List<RoommateScoreDTO> getRoommateScore() {
//    }
//
//    public boolean allotRoom(String roomId, List<String> studentIds) {
//
//    }

    public WardenFullProfileDTO getMyProfile(String id) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("No user found!"));
        WardenProfile wardenProfile=wardenProfileRepo.findByUserId(id);
        if(wardenProfile==null){
             wardenProfile=new WardenProfile();
             wardenProfile.setUserId(user.getId());
        }
        return new WardenFullProfileDTO(user,wardenProfile);
    }

    public WardenFullProfileDTO updateProfile(String id, WardenProfileUpdateDTO updateDTO) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("No user found!"));
        WardenProfile wardenProfile=wardenProfileRepo.findByUserId(id);
        if(wardenProfile==null){
            wardenProfile=new WardenProfile();
            wardenProfile.setUserId(user.getId());
        }
        if(updateDTO.getEmail()!=null){
            user.setEmail(updateDTO.getEmail());
        }
        if(updateDTO.getName()!=null){
            user.setName(updateDTO.getName());
        }
        if(updateDTO.getContactNo()!=null){
            user.setContactNo(updateDTO.getContactNo());
        }
        if(updateDTO.getHostelType()!=null){
            wardenProfile.setHostelType(updateDTO.getHostelType());
        }
        userRepo.save(user);
        wardenProfileRepo.save(wardenProfile);
        return new WardenFullProfileDTO(user,wardenProfile);
    }

    public void updatePassword(String id, WardenController.PasswordUpdateRequest passwordUpdateRequest) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("No user found!"));
        if(!passwordEncoder.matches(passwordUpdateRequest.getOldPassword(), user.getPassword())){
            throw new RuntimeException("Incorrect password!");
        }
        user.setPassword(passwordEncoder.encode(passwordUpdateRequest.getNewPassword()));
        userRepo.save(user);
    }
}
