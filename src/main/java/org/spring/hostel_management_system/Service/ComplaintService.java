package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.DTO.ComplaintDTO;
import org.spring.hostel_management_system.Model.Complaint;
import org.spring.hostel_management_system.Repository.ComplaintRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    private final ComplaintRepo complaintRepo;

    public ComplaintService(ComplaintRepo complaintRepo) {
        this.complaintRepo = complaintRepo;
    }

    public List<Complaint> getAllComplaint() {
        return complaintRepo.findAll();
    }

    public Complaint getComplaintById(String id) {
        return complaintRepo.findById(id).orElseThrow(()->new RuntimeException("Complaint not found!"));
    }

    public void resolveComplaint(String id) {
        Complaint complaint=complaintRepo.findById(id).orElseThrow(()->new RuntimeException("No such complaint found!"));
        complaint.setStatus(Complaint.Status.RESOLVED);
        complaintRepo.save(complaint);
    }

    public Complaint fileComplaint(String id, ComplaintDTO complaintDTO) {
        Complaint complaint=new Complaint();
        complaint.setStudentId(id);
        complaint.setRoomId(complaintDTO.getRoomId());
        complaint.setTitle(complaintDTO.getTitle());
        complaint.setDescription(complaintDTO.getDescription());
        complaint.setStatus(Complaint.Status.PENDING);
        return complaintRepo.save(complaint);
    }

    public List<Complaint> getMyComplaint(String id) {
        return complaintRepo.findAllByStudentId(id);
    }
}
