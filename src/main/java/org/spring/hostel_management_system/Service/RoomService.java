package org.spring.hostel_management_system.Service;

import org.spring.hostel_management_system.Model.HostelType;
import org.spring.hostel_management_system.Model.Rooms;
import org.spring.hostel_management_system.Repository.RoomsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomsRepo roomsRepo;

    public RoomService(RoomsRepo roomsRepo) {
        this.roomsRepo = roomsRepo;
    }

    public List<Rooms> getAvailableRooms(HostelType hostelType, int year) {
        String block=getBlockByYear(hostelType, year);
        return roomsRepo.findAllByBookedFalseAndHostelTypeAndBlock(hostelType, block);
    }

    private String getBlockByYear(HostelType hostelType ,int year) {
        return switch (hostelType){
            case GIRLS_HOSTEL-> switch (year){
                 case 1->"B";
                 case 2->"C";
                 case 3, 4 ->"A";
                 default -> throw new RuntimeException("Invalid year");
            };
            case BOYS_HOSTEL-> switch (year){
                case 1->"ABB";
                case 2->"Chankya";
                case 3, 4 ->"AB";
                default -> throw new RuntimeException("Invalid year");
            };
            default -> throw new RuntimeException("Invalid hostelType");
        };
    }

    public void releaseRoom(String roomId) {
        Rooms room=roomsRepo.findById(roomId).orElseThrow(()->new RuntimeException("Room not found!"));
        room.setBooked(false);
        roomsRepo.save(room);
    }

    public List<Rooms> getAllRooms() {
        return roomsRepo.findAll();
    }
}
