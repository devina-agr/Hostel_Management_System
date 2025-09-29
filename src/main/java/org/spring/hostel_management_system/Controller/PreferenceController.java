package org.spring.hostel_management_system.Controller;
import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Model.UserPrincipal;
import org.spring.hostel_management_system.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/preference")
@PreAuthorize("hasRole('STUDENT')")
public class PreferenceController {

    private final StudentService studentService;

    public PreferenceController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/room-type")
    public ResponseEntity<List<Integer>> getRoomType(@AuthenticationPrincipal UserPrincipal userPrincipal){
        User student=studentService.getStudentById(userPrincipal.getId());
        HostelType hostelType=studentService.getHostelType();
        if(student==null || hostelType==null){
            return ResponseEntity.badRequest().build();
        }
        
    }

}
