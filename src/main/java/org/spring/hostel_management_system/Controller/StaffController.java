package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.DTO.StaffFullProfileDTO;
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
    private final ComplaintService complaintService;
    private final FeedbackService feedbackService;

    public StaffController(StaffService staffService, ComplaintService complaintService, FeedbackService feedbackService) {
        this.staffService = staffService;
        this.complaintService=complaintService;
        this.feedbackService=feedbackService;
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
    public ResponseEntity<StaffFullProfileDTO> updateProfile(@AuthenticationPrincipal UserPrincipal staff, @RequestBody StaffProfile staffProfile){
        User user=staffService.getStaffById(staff.getId());
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(staffService.updateProfile(staff.getId(),staffProfile));
    }

    @GetMapping("/complaint")
    public ResponseEntity<List<Complaint>> getAllComplaints(){
        return ResponseEntity.ok(complaintService.getAllComplaint());
    }

    @GetMapping("/complaint/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable String id){
        Complaint complaint=complaintService.getComplaintById(id);
        if(complaint==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/feedback")
    public ResponseEntity<List<Feedback>> getAllFeedback(){
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable String id){
        Feedback feedback=feedbackService.getFeedbackById(id);
        if(feedback==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/complaint/{id}/resolve")
    public ResponseEntity<Complaint> resolveComplaint(@PathVariable String id){
        Complaint complaint=complaintService.getComplaintById(id);
        if(complaint==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(complaintService.resolveComplaint(id));
    }

}
