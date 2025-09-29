package org.spring.hostel_management_system.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class RoomAllocation {

    private String id;
    private Preference preference;
    private String studentId;
    private String roomId;
    private Date allottedFrom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Date getAllottedFrom() {
        return allottedFrom;
    }

    public void setAllottedFrom(Date allottedFrom) {
        this.allottedFrom = allottedFrom;
    }
}
