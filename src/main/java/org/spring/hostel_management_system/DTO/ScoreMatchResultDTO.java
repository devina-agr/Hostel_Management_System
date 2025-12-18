package org.spring.hostel_management_system.DTO;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.RoomType;

import java.util.List;

public class ScoreMatchResultDTO {

    private List<String> studentIds;
    private double score;
    private RoomType roomType;
    private HostelType hostelType;

    public ScoreMatchResultDTO(String studentId, String studentId1, double score) {
        this.score=score;
    }

    public ScoreMatchResultDTO(List<String> studentId, double v, RoomType roomType, HostelType hostelType) {
    }


    public List<String> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public HostelType getHostelType() {
        return hostelType;
    }

    public void setHostelType(HostelType hostelType) {
        this.hostelType = hostelType;
    }
}
