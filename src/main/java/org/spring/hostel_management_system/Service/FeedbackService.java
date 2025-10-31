package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.DTO.FeedbackDTO;
import org.spring.hostel_management_system.Model.Feedback;
import org.spring.hostel_management_system.Repository.FeedbackRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepo feedbackRepo;

    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }

    public Feedback getFeedbackById(String id) {
        return feedbackRepo.findById(id).orElseThrow(()->new RuntimeException("No feedback found!"));
    }

    public Feedback giveFeedback(String id, FeedbackDTO feedbackDTO) {
        Feedback feedback=new Feedback();
        feedback.setComment(feedbackDTO.getComment());
        feedback.setRating(feedbackDTO.getRating());
        feedback.setStudentId(id);
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> getMyFeedback(String id) {
        return feedbackRepo.findAllByStudentId(id);
    }
}
