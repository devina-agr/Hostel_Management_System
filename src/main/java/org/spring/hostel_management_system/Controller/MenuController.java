package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Menu;
import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Model.UserPrincipal;
import org.spring.hostel_management_system.Service.MenuService;
import org.spring.hostel_management_system.Service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;
    private final StudentProfileService studentProfileService;

    public MenuController(MenuService menuService, StudentProfileService studentProfileService) {
        this.menuService = menuService;
        this.studentProfileService = studentProfileService;
    }

    public ResponseEntity<List<Menu>> getMenu(@AuthenticationPrincipal UserPrincipal userPrincipal){
        StudentProfile studentProfile=studentProfileService.getStudentByUserId(userPrincipal.getId());
        if(studentProfile==null || studentProfile.getHostelType()==null){
            return ResponseEntity.badRequest().build();
        }
        List<Menu> menu=menuService.getMenuByHostel(studentProfile.getHostelType());
        if(menu.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(menu);
    }

}
