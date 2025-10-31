package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.DTO.PreferenceDTO;
import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Preference;
import org.spring.hostel_management_system.Model.RoomType;
import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Repository.PreferenceRepo;
import org.spring.hostel_management_system.Repository.StudentProfileRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferenceService {

    private final PreferenceRepo preferenceRepo;
    private final StudentProfileRepo studentProfileRepo;

    public PreferenceService(PreferenceRepo preferenceRepo, StudentProfileRepo studentProfileRepo) {
        this.preferenceRepo = preferenceRepo;
        this.studentProfileRepo = studentProfileRepo;
    }

    public boolean hasSubmitted(String id) {
        return preferenceRepo.findByStudentId(id).isPresent();
    }

    public Preference savePreference(String id, PreferenceDTO preferenceDTO) {
        if(hasSubmitted(id)){
            throw new IllegalStateException("Preference already submitted!");
        }
        Optional<StudentProfile> studentProfile=studentProfileRepo.findByStudentId(id);
        if(studentProfile.isEmpty()){
            throw new IllegalArgumentException("Student profile not found!");
        }

        StudentProfile studentProfile1=studentProfile.get();

        HostelType hostelType=studentProfile1.getHostelType();
        if(hostelType==null){
            throw new IllegalStateException("Hostel type not selected yet!");
        }
        List<Integer> roomType= RoomType.getOptionsForRoomType(hostelType);
        if(!roomType.contains(preferenceDTO.getRoomType().getValue())){
            throw new IllegalArgumentException("Invalid room type selected for this hostel!");
        }

        Preference preference=new Preference();
        preference.setNoisePreference(preferenceDTO.getNoisePreference());
        preference.setStudyPreference(preferenceDTO.getStudyPreference());
        preference.setRoomTempPreference(preferenceDTO.getRoomTempPreference());
        preference.setAllergy(preferenceDTO.getAllergy());
        preference.setCleanlinessLevel(preferenceDTO.getCleanlinessLevel());
        preference.setScheduleType(preferenceDTO.getScheduleType());
        preference.setHobbies(preferenceDTO.getHobbies());
        preference.setRoomType(preferenceDTO.getRoomType());
        preference.setStudentId(id);
        Preference savedPreference= preferenceRepo.save(preference);
        studentProfile1.setPreference(savedPreference);
        studentProfileRepo.save(studentProfile1);
        return savedPreference;
    }

    public Preference getPreferenceByStudentId(String id) {
        return preferenceRepo.findByStudentId(id).orElse(null);
    }
}
