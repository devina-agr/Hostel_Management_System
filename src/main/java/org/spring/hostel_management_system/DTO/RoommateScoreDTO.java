package org.spring.hostel_management_system.DTO;

public class RoommateScoreDTO {

    private String student1Id;
    private String student2Id;
    private String studentName1;
    private String studentName2;
    private double compatibilityScore;
    private boolean assignedTogether;

    public String getStudent1Id() {
        return student1Id;
    }

    public void setStudent1Id(String student1Id) {
        this.student1Id = student1Id;
    }

    public String getStudent2Id() {
        return student2Id;
    }

    public void setStudent2Id(String student2Id) {
        this.student2Id = student2Id;
    }

    public String getStudentName1() {
        return studentName1;
    }

    public void setStudentName1(String studentName1) {
        this.studentName1 = studentName1;
    }

    public String getStudentName2() {
        return studentName2;
    }

    public void setStudentName2(String studentName2) {
        this.studentName2 = studentName2;
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
