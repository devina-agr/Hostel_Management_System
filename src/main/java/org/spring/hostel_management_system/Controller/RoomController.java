package org.spring.hostel_management_system.Controller;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Rooms;
import org.spring.hostel_management_system.Repository.RoomsRepo;
import org.spring.hostel_management_system.Service.RoomService;
import org.spring.hostel_management_system.Service.WardenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@PreAuthorize("hasRole('WARDEN')")
public class RoomController {

    private final RoomsRepo roomsRepo;
    private final RoomService roomService;
    private final WardenService wardenService;

    public RoomController(RoomsRepo roomsRepo, RoomService roomService, WardenService wardenService) {
        this.roomsRepo = roomsRepo;
        this.roomService = roomService;
        this.wardenService = wardenService;
    }

    @GetMapping("/available/{hostelType}/{year}")
    public ResponseEntity<List<Rooms>> getAvailableRooms(@PathVariable HostelType hostelType, @PathVariable int year) {
        return ResponseEntity.ok(roomService.getAvailableRooms(hostelType, year));
    }

    @PostMapping("/room-allotment")
    public ResponseEntity<String> assignRoom(@RequestParam String roomId,@RequestParam String... studentIds){
        boolean success=wardenService.allotRoom(roomId,List.of(studentIds));
        if(success){
            return ResponseEntity.ok("Room allotted successfully!");
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room allotment failed!");
        }
    }

    @PostMapping("/release")
    public ResponseEntity<String> releaseRoom(@PathVariable String roomId){
        roomService.releaseRoom(roomId);
        return ResponseEntity.ok("Room released successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Rooms>> getAllRooms(){
        return ResponseEntity.ok(roomService.getAllRooms());
    }

}
