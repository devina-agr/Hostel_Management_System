package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.DTO.FeedbackDTO;
import org.spring.hostel_management_system.Model.Complaint;
import org.spring.hostel_management_system.Model.Feedback;
import org.spring.hostel_management_system.Model.UserPrincipal;
import org.spring.hostel_management_system.Service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('STAFF','WARDEN')")
    public ResponseEntity<List<Feedback>> getAllFeedback(){
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('STAFF','WARDEN')")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable String id){
        Feedback feedback=feedbackService.getFeedbackById(id);
        if(feedback==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(feedback);
    }

    @PostMapping
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<Feedback> giveFeedback(@AuthenticationPrincipal UserPrincipal user, @RequestBody FeedbackDTO feedbackDTO){
        return ResponseEntity.ok(feedbackService.giveFeedback(user.getId(),feedbackDTO));
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<List<Feedback>> getMyFeedback(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(feedbackService.getMyFeedback(userPrincipal.getId()));
    }

}
