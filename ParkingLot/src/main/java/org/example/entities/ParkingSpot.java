package org.example.entities;

import lombok.AllArgsConstructor;

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
}
