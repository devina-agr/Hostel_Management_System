package org.spring.hostel_management_system.DTO;

import java.util.List;

public class RoommateScoreDTO {

    private List<String> studentIds;
    private List<String> studentNames;
    private double compatibilityScore;
    private boolean assignedTogether;

    public List<String> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }

    public double getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(double compatibilityScore) {
        this.compatibilityScore = compatibilityScore;
    }

    public boolean isAssignedTogether() {
        return assignedTogether;
    }

    public void setAssignedTogether(boolean assignedTogether) {
        this.assignedTogether = assignedTogether;
    }
}
