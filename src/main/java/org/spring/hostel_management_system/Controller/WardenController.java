package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.DTO.*;
import org.spring.hostel_management_system.Model.*;
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
    private final ComplaintService complaintService;
    private final FeedbackService feedbackService;

    public WardenController(WardenService wardenService, ComplaintService complaintService, FeedbackService feedbackService) {
        this.wardenService = wardenService;
        this.complaintService = complaintService;
        this.feedbackService = feedbackService;
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
    public ResponseEntity<User> addWarden(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody WardenRegisterDTO warden){
        User warden1 =wardenService.addWarden(userPrincipal.getId(), warden);
        return ResponseEntity.ok(warden1);
    }

    @PostMapping("/register-staff")
    public ResponseEntity<StaffFullProfileDTO> addStaff(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody StaffRegisterDTO staffRegisterDTO){
        StaffFullProfileDTO staffDTO=wardenService.addStaff(userPrincipal.getId(),staffRegisterDTO);
        return ResponseEntity.ok(staffDTO);
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

    @GetMapping("/compatibility-score")
    public ResponseEntity<List<RoommateScoreDTO>> getRoommateScore(){
        return ResponseEntity.ok(wardenService.getRoommateScore());
    }

    @PostMapping("/room-allotment")
    public ResponseEntity<String> assignRoom(@RequestParam String studentId1, @RequestParam String studentId2, @RequestParam String roomId){
        boolean success=wardenService.allotRoom(studentId1,studentId2,roomId);
        if(success){
            return ResponseEntity.ok("Room allotted successfully!");
        }
        else{
            return ResponseEntity.ok("Room allotment failed!");
        }
    }






}
