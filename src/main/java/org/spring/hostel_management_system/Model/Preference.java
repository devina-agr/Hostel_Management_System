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
    private SleepPattern sleepPattern;
    private Hobbies hobbies;
    private RoomTempPreference roomTempPreference;
    private RoomType roomType;

    public enum ScheduleType{
        MORNING_PERSON,
        NIGHT_PERSON
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
    public enum SleepPattern{
        EARLY,
        LATE
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
        COOL,
        NORMAL,
        WARM
    }


}
