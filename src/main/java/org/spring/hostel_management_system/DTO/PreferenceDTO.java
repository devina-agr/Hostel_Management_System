package org.spring.hostel_management_system.DTO;

import org.spring.hostel_management_system.Model.Preference;
import org.spring.hostel_management_system.Model.RoomType;

public class PreferenceDTO {

    private Preference.ScheduleType scheduleType;
    private Preference.CleanlinessLevel cleanlinessLevel;
    private Preference.NoisePreference noisePreference;
    private Preference.StudyPreference studyPreference;
    private Preference.Allergy allergy;
    private Preference.RoomTempPreference roomTempPreference;
    private RoomType roomType;

    public Preference.ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(Preference.ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public Preference.CleanlinessLevel getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(Preference.CleanlinessLevel cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public Preference.NoisePreference getNoisePreference() {
        return noisePreference;
    }

    public void setNoisePreference(Preference.NoisePreference noisePreference) {
        this.noisePreference = noisePreference;
    }

    public Preference.StudyPreference getStudyPreference() {
        return studyPreference;
    }

    public void setStudyPreference(Preference.StudyPreference studyPreference) {
        this.studyPreference = studyPreference;
    }

    public Preference.Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Preference.Allergy allergy) {
        this.allergy = allergy;
    }

    public Preference.RoomTempPreference getRoomTempPreference() {
        return roomTempPreference;
    }

    public void setRoomTempPreference(Preference.RoomTempPreference roomTempPreference) {
        this.roomTempPreference = roomTempPreference;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
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
    public enum Hobbies{
        MUSIC,
        CODING,
        DANCE,
        ART,
        READING,
        OUTDOOR_GAMES,
        OTHERS
    }
    public enum RoomTempPreference{
        CHILLED,
        COOL,
        NORMAL,
        FLEXIBLE
    }
}
