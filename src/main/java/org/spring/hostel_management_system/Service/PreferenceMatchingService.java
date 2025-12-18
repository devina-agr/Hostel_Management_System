package org.spring.hostel_management_system.Service;
import org.spring.hostel_management_system.DTO.ScoreMatchResultDTO;
import org.spring.hostel_management_system.Model.*;
import org.spring.hostel_management_system.Repository.PreferenceRepo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PreferenceMatchingService {

    private final PreferenceRepo preferenceRepo;

    public PreferenceMatchingService(PreferenceRepo preferenceRepo) {
        this.preferenceRepo = preferenceRepo;
    }

    public List<ScoreMatchResultDTO> calculateScoreForAll() {
        List<Preference> allPrefs = preferenceRepo.findAll();
        Map<String, List<Preference>> buckets = new HashMap<>();
        for (Preference pref : allPrefs) {
            HostelType hostelType = getHostelTypeForStudent(pref);
            RoomType roomType = pref.getRoomType();


        }

        List<ScoreMatchResultDTO> allResults = new ArrayList<>();

        for (Map.Entry<String, List<Preference>> entry : buckets.entrySet()) {
            List<Preference> bucketPref = entry.getValue();

            if (bucketPref.isEmpty()) {
                continue;
            }
            HostelType hostelType = getHostelTypeForStudent(bucketPref.getFirst());
            RoomType roomType = bucketPref.getFirst().getRoomType();
            int seater = roomType.getValue();

            if (seater == 1) {
                for (Preference pref : bucketPref) {
                    allResults.add(new ScoreMatchResultDTO(List.of(pref.getStudentId()), 1.0, roomType, hostelType));
                }
                continue;
            }

            List<List<Preference>> combinations = generateCombinations(bucketPref, seater);
            for (List<Preference> group : combinations) {
                double score = calculateGroupScore(group);
                List<String> ids = group.stream().map(Preference::getStudentId).toList();

                allResults.add(new ScoreMatchResultDTO(ids, score, roomType, hostelType));
            }

        }
        return allResults;

    }

    private double calculateGroupScore(List<Preference> group) {
        double total=0;
        int pairs=0;
        for(int i=0;i<group.size();i++){
            for(int j=i+1;j<group.size();j++){
                total+=calculatePairScore(group.get(i),group.get(j));
                pairs++;
            }
        }
        return pairs>0?total/pairs:1.0;
    }

    private double calculatePairScore(Preference p1, Preference p2) {
        int matches=0;
        int total=7;
        if (p1.getScheduleType() == p2.getScheduleType()) matches++;
        if (p1.getCleanlinessLevel() == p2.getCleanlinessLevel()) matches++;
        if (p1.getNoisePreference() == p2.getNoisePreference()) matches++;
        if (p1.getStudyPreference() == p2.getStudyPreference()) matches++;
        if (p1.getAllergy() == p2.getAllergy()) matches++;
        if (p1.getRoomTempPreference() == p2.getRoomTempPreference()) matches++;

        return (double) matches/total;
    }

    private List<List<Preference>> generateCombinations(List<Preference> bucketPref, int seater) {
        List<List<Preference>> result=new ArrayList<>();
        backtrack(bucketPref,seater,0,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(List<Preference> bucketPref, int seater, int index, ArrayList<Preference> current, List<List<Preference>> result) {
        if(current.size()==seater){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<bucketPref.size();i++){
            current.add(bucketPref.get(i));
            backtrack(bucketPref,seater,i+1,current,result);
            current.removeLast();
        }
    }


    private HostelType getHostelTypeForStudent(Preference pref) {
//        StudentProfile studentProfile=studentProfileRepo.findByStudentId(pref.getStudentId()).orElseThrow(()->new RuntimeException("No profile found!"));
//        return studentProfile.getHostelType();
        return pref.getRoomType().getHostelType().getFirst();
    }
}