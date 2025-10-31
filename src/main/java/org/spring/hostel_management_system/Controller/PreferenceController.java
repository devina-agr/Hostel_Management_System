package org.spring.hostel_management_system.Controller;
import org.spring.hostel_management_system.DTO.PreferenceDTO;
import org.spring.hostel_management_system.Model.*;
import org.spring.hostel_management_system.Service.PreferenceService;
import org.spring.hostel_management_system.Service.StudentProfileService;
import org.spring.hostel_management_system.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preference")
@PreAuthorize("hasRole('STUDENT')")
public class PreferenceController {

    private final StudentService studentService;
    private final StudentProfileService studentProfileService;
    private final PreferenceService preferenceService;

    public PreferenceController(StudentService studentService, StudentProfileService studentProfileService, PreferenceService preferenceService) {
        this.studentService = studentService;
        this.studentProfileService = studentProfileService;
        this.preferenceService = preferenceService;
    }

    @GetMapping("/room-type")
    public ResponseEntity<List<Integer>> getRoomType(@AuthenticationPrincipal UserPrincipal userPrincipal){
        StudentProfile studentProfile=studentProfileService.getStudentByUserId(userPrincipal.getId());
        if(studentProfile==null){
            return ResponseEntity.badRequest().build();
        }
        HostelType hostelType=studentProfile.getHostelType();
        if(hostelType==null){
            return ResponseEntity.badRequest().build();
        }
        List<Integer> roomOptions= RoomType.getOptionsForRoomType(hostelType);
        return ResponseEntity.ok(roomOptions);
    }

    @PostMapping
    public ResponseEntity<Preference> submitPreference(@AuthenticationPrincipal UserPrincipal user, @RequestBody PreferenceDTO preferenceDTO){
        if(preferenceService.hasSubmitted(user.getId())){
            return ResponseEntity.badRequest().body(null);
        }
        StudentProfile studentProfile =studentProfileService.getStudentByUserId(user.getId());
        if(studentProfile.getHostelType()==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(preferenceService.savePreference(user.getId(), preferenceDTO));
    }

    @GetMapping("/my-preference")
    public ResponseEntity<Preference> getMyPreference(@AuthenticationPrincipal UserPrincipal user){
        Preference preference=preferenceService.getPreferenceByStudentId(user.getId());
        if(preference==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(preference);
    }


}
