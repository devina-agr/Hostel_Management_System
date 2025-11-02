package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.DTO.StaffFullProfileDTO;
import org.spring.hostel_management_system.DTO.StaffProfileUpdateDTO;
import org.spring.hostel_management_system.Model.*;
import org.spring.hostel_management_system.Service.ComplaintService;
import org.spring.hostel_management_system.Service.FeedbackService;
import org.spring.hostel_management_system.Service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@PreAuthorize("hasRole('STAFF')")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/me")
    public ResponseEntity<StaffFullProfileDTO> myProfile(@AuthenticationPrincipal UserPrincipal staff){
        User user=staffService.getStaffById(staff.getId());
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(staffService.getProfile(staff.getId()));
    }

    @PutMapping("/update-profile")
    public ResponseEntity<StaffFullProfileDTO> updateProfile(@AuthenticationPrincipal UserPrincipal staff, @RequestBody StaffProfileUpdateDTO staffProfile){
        User user=staffService.getStaffById(staff.getId());
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(staffService.updateProfile(staff.getId(),staffProfile));
    }

    @PostMapping("/update-profile/update-password")
    public ResponseEntity<String> updatePassword(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody WardenController.PasswordUpdateRequest passwordUpdateRequest){
       staffService.updatePassword(userPrincipal.getId(), passwordUpdateRequest.getOldPassword(), passwordUpdateRequest.getNewPassword());
       return ResponseEntity.ok("Password updated successfully!");
    }


}
