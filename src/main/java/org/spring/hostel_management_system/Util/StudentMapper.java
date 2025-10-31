package org.spring.hostel_management_system.Util;

import org.spring.hostel_management_system.DTO.StudentFullProfileDTO;
import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Model.User;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentFullProfileDTO toFullDTO(User user, StudentProfile studentProfile){
        StudentFullProfileDTO studentFullProfileDTO=new StudentFullProfileDTO(user,studentProfile);
        studentFullProfileDTO.setId(user.getId());
        studentFullProfileDTO.setName(user.getName());
        studentFullProfileDTO.setEmail(user.getEmail());
        studentFullProfileDTO.setContactNo(user.getContactNo());
        studentFullProfileDTO.setRole(user.getRole());

        if(studentProfile!=null){
            studentFullProfileDTO.setBranch(studentProfile.getBranch());
            studentFullProfileDTO.setGender(studentProfile.getGender());
            studentFullProfileDTO.setParentContactNo(studentProfile.getParentContactNo());
            studentFullProfileDTO.setYear(studentProfile.getYear());
            studentFullProfileDTO.setPreference(studentProfile.getPreference());
            studentFullProfileDTO.setHostelType(studentProfile.getHostelType());
            studentFullProfileDTO.setRoomId(studentFullProfileDTO.getRoomId());
        }

        return studentFullProfileDTO;
    }
}
