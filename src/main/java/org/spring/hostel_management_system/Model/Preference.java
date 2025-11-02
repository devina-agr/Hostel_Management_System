package org.spring.hostel_management_system.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
@Document(collection = "Preference")
public class Preference {

    private String id;
    private String studentId;

    private ScheduleType scheduleType;
    private CleanlinessLevel cleanlinessLevel;
    private NoisePreference noisePreference;
    private StudyPreference studyPreference;
    private Allergy allergy;
    private RoomTempPreference roomTempPreference;
    private RoomType roomType;
    private FoodPreference foodPreference;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public NoisePreference getNoisePreference() {
        return noisePreference;
    }

    public void setNoisePreference(NoisePreference noisePreference) {
        this.noisePreference = noisePreference;
    }

    public StudyPreference getStudyPreference() {
        return studyPreference;
    }

    public void setStudyPreference(StudyPreference studyPreference) {
        this.studyPreference = studyPreference;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }
    public RoomTempPreference getRoomTempPreference() {
        return roomTempPreference;
    }

    public void setRoomTempPreference(RoomTempPreference roomTempPreference) {
        this.roomTempPreference = roomTempPreference;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public FoodPreference getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(FoodPreference foodPreference) {
        this.foodPreference = foodPreference;
    }

    public enum ScheduleType{
        MORNING_PERSON,
        NIGHT_PERSON,
        FLEXIBLE
    }
    public enum CleanlinessLevel{
        HIGH,
        MEDIUM,
        LOW
    }
    public enum NoisePreference{
        QUIET,
        OKAY,
        NOISY
    }
    public enum StudyPreference{
        ALONE,
        GROUP,
        FLEXIBLE
    }
    public enum Allergy{
        DIRT,
        PERFUME,
        OTHERS
    }

    public enum RoomTempPreference{
        CHILLED,
        COOL,
        NORMAL,
        FLEXIBLE
    }
    public enum FoodPreference{
        VEGETARIAN,
        NON_VEGETARIAN,
        FLEXIBLE
    }



}
