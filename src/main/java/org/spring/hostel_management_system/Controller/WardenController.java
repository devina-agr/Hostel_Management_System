package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.DTO.*;
import org.spring.hostel_management_system.Model.*;
import org.spring.hostel_management_system.Repository.UserRepo;
import org.spring.hostel_management_system.Service.ComplaintService;
import org.spring.hostel_management_system.Service.FeedbackService;
import org.spring.hostel_management_system.Service.WardenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warden")
@PreAuthorize("hasRole('WARDEN')")
public class WardenController {

    private final WardenService wardenService;
    private final UserRepo userRepo;

    public WardenController(WardenService wardenService, UserRepo userRepo) {
        this.wardenService = wardenService;
        this.userRepo = userRepo;
    }

    @GetMapping("/all-students")
    public ResponseEntity<List<StudentFullProfileDTO>> getAllStudents(){
        return ResponseEntity.ok(wardenService.getAllStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentFullProfileDTO> getStudentById(@PathVariable String id){
        return ResponseEntity.ok(wardenService.getStudentById(id));
    }

    @PostMapping("/register-warden")
    public ResponseEntity<WardenFullProfileDTO> addWarden(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody WardenRegisterDTO warden){
        WardenFullProfileDTO warden1 =wardenService.addWarden(userPrincipal.getId(), warden);
        return ResponseEntity.ok(warden1);
    }

    @PostMapping("/register-staff")
    public ResponseEntity<StaffFullProfileDTO> addStaff(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody StaffRegisterDTO staffRegisterDTO){
        StaffFullProfileDTO staffDTO=wardenService.addStaff(userPrincipal.getId(),staffRegisterDTO);
        return ResponseEntity.ok(staffDTO);
    }
    @GetMapping("/compatibility-score")
    public ResponseEntity<List<RoommateScoreDTO>> getRoommateScore(){
        return ResponseEntity.ok(wardenService.getRoommateScore());
    }

    @GetMapping("/me")
    public ResponseEntity<WardenFullProfileDTO> getMyProfile(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(wardenService.getMyProfile(userPrincipal.getId()));
    }

    @PostMapping("/update-profile")
    public ResponseEntity<WardenFullProfileDTO> updateProfile(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody WardenProfileUpdateDTO updateDTO){

        return ResponseEntity.ok(wardenService.updateProfile(userPrincipal.getId(),updateDTO));
    }

    @PostMapping("/update-profile/update-password")
    public ResponseEntity<String> updatePassword(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestParam String oldPassword, @RequestParam String newPassword){

        wardenService.updatePassword(userPrincipal.getId(),oldPassword,newPassword);
        return ResponseEntity.ok("Password updated successfully!");
    }

}
