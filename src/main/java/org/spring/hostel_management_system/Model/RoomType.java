package org.spring.hostel_management_system.Model;

import java.util.Arrays;
import java.util.List;

public enum RoomType {
    ONE(1, HostelType.GIRLS_HOSTEL),
    TWO(2, HostelType.GIRLS_HOSTEL, HostelType.BOYS_HOSTEL),
    THREE(3, HostelType.GIRLS_HOSTEL, HostelType.BOYS_HOSTEL),
    FOUR(4, HostelType.BOYS_HOSTEL),
    SIX(6, HostelType.BOYS_HOSTEL);

    private final int value;
    private final List<HostelType> hostelType;

    RoomType(int value, HostelType... hostelType) {
        this.hostelType = List.of(hostelType);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public List<HostelType> getHostelType() {
        return hostelType;
    }

    public static List<Integer> getOptionsForRoomType(HostelType hostelType) {
        return Arrays.stream(RoomType.values())
                .filter(s -> s.getHostelType().contains(hostelType))
                .map(RoomType::getValue)
                .toList();
    }

}
