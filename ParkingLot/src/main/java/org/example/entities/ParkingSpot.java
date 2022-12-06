package org.example.entities;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ParkingSpot {

    int number;
    Vehicle.Type type;
    Vehicle vehicle;

    boolean isOccupied() {
        return vehicle != null;
    }

    public boolean park(Vehicle vehicle) {
        if (isOccupied()) {
            System.out.println("Parking spot is occupied");
            return false;
        }
        if (vehicle.type != type) {
            System.out.println("Vehicle type does not match parking spot type");
            return false;
        }
        this.vehicle = vehicle;
        return true;
    }

    public static List<ParkingSpot> createSpots(Vehicle.Type type, int capacity) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            parkingSpots.add(new ParkingSpot(i, type, null));
        }
        return parkingSpots;
    }
}
