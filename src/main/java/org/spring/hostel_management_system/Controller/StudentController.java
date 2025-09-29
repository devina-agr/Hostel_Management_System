package org.spring.hostel_management_system.Controller;
import org.spring.hostel_management_system.DTO.StudentFullProfileDTO;
import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Model.UserPrincipal;
import org.spring.hostel_management_system.Service.StudentProfileService;
import org.spring.hostel_management_system.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    private final StudentService studentService;
    private final StudentProfileService studentProfileService;

    public StudentController(StudentService studentService, StudentProfileService studentProfileService) {
        this.studentService = studentService;
        this.studentProfileService = studentProfileService;
    }

    @GetMapping("/profile")
    public ResponseEntity<StudentFullProfileDTO> getMyProfile(@AuthenticationPrincipal UserPrincipal user){
        User student=studentService.getStudentById(user.getId());
        if(student==null){
            return ResponseEntity.notFound().build();
        }
        StudentProfile studentProfile=studentProfileService.getStudentByUserId(user.getId());
        if(studentProfile==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentService.getMyProfile(user.getId()));
    }

    @PutMapping("/profile")
    public ResponseEntity<StudentFullProfileDTO> updateProfile(@AuthenticationPrincipal UserPrincipal user, @RequestBody StudentProfile profile){
        User student=studentService.getStudentById(user.getId());
        if(student==null){
            return ResponseEntity.notFound().build();
        }
        StudentProfile studentProfile=studentProfileService.getStudentByUserId(user.getId());
        if(studentProfile==null){
            return ResponseEntity.notFound().build();
        }
        if(profile.getBranch()!=null){
            studentProfile.setBranch(profile.getBranch());
        }
        if(profile.getHostelType()!=null){
            studentProfile.setHostelType(profile.getHostelType());
        }
        if(profile.getGender()!=null){
            studentProfile.setGender(profile.getGender());
        }
        if(profile.getParentContactNo()!=null){
            studentProfile.setParentContactNo(profile.getParentContactNo());
        }
        if(profile.getYear()!=0){
            studentProfile.setYear(profile.getYear());
        }
        studentProfileService.updateProfile(studentProfile);
        StudentFullProfileDTO studentFullProfileDTO=studentService.getMyProfile(user.getId());
        return ResponseEntity.ok(studentFullProfileDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        User user=studentService.getStudentById(userPrincipal.getId());
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        studentService.deleteUser(userPrincipal.getId());
        studentProfileService.deleteProfileByUserId(userPrincipal.getId());
        return ResponseEntity.noContent().build();
    }
}
