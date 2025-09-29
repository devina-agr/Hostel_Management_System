package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.RoomType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/room-types")

public class RoomTypeController {

    @GetMapping("/options")
    public ResponseEntity<List<Integer>> getRoomType(@RequestParam HostelType hostelType){
        return ResponseEntity.ok(RoomType.getOptionsForRoomType(hostelType));
    }
}
