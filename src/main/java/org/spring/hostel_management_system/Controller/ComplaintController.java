package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.DTO.ComplaintDTO;
import org.spring.hostel_management_system.Model.Complaint;
import org.spring.hostel_management_system.Model.User;
import org.spring.hostel_management_system.Model.UserPrincipal;
import org.spring.hostel_management_system.Service.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {


    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('WARDEN','STAFF')")
    public ResponseEntity<List<Complaint>> getAllComplaints(){
        return ResponseEntity.ok(complaintService.getAllComplaint());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('WARDEN','STAFF')")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable String id){
        Complaint complaint=complaintService.getComplaintById(id);
        if(complaint==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(complaint);
    }

    @PutMapping("/{id}/resolve")
    @PreAuthorize("hasRole('WARDEN')")
    public ResponseEntity<String> resolveComplaint(@PathVariable String id){
        Complaint complaint=complaintService.getComplaintById(id);
        if(complaint==null){
            return ResponseEntity.notFound().build();
        }
        complaintService.resolveComplaint(id);
        return ResponseEntity.ok("Complaint resolved successfully!");
    }

    @PostMapping
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<Complaint> fileComplaint(@AuthenticationPrincipal UserPrincipal user, @RequestBody ComplaintDTO complaintDTO){
        return ResponseEntity.ok(complaintService.fileComplaint(user.getId(),complaintDTO));
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<List<Complaint>> getMyComplaint(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(complaintService.getMyComplaint(userPrincipal.getId()));
    }


}
