package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Menu;
import org.spring.hostel_management_system.Model.StudentProfile;
import org.spring.hostel_management_system.Repository.MenuRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepo menuRepo;

    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    public List<Menu> getMenuByHostel(HostelType hostelType) {
        return menuRepo.findByHostelType(hostelType);
    }
}
