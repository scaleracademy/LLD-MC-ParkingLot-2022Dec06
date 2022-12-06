package org.example.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingLot {

    List<ParkingFloor> floors;
    Map<Vehicle.Type, Integer> parkingFees;

    public static class Builder {
        private int numFloors;
        List<ParkingFloor> floors;
        Map<Vehicle.Type, Integer> parkingFees;

        public Builder(int numFloors) {
            this.numFloors = numFloors;
            this.floors = new ArrayList<>(numFloors);
            this.parkingFees = new HashMap<>();
        }

        public Builder addFloor(ParkingFloor floor) {
            if (floors.size() == numFloors) {
                System.out.println("Cannot add more floors");
                return this;
            }
            floors.add(floor);
            return this;
        }
        public Builder setDefaultParkingFees(int fee) {
            Arrays.asList(Vehicle.Type.values()).forEach(type -> parkingFees.put(type, fee));
            return this;
        }

        public Builder setParkingFees(Vehicle.Type type, int fee) {
            this.parkingFees.put(type, fee);
            return this;
        }

        public ParkingLot build() {
            if (floors.size() < numFloors) {
                throw new IllegalStateException("All floors are not defined");
            }
            if (parkingFees.size() < Vehicle.Type.values().length) {
                throw new IllegalStateException("Parking fees are not defined for all vehicle types");
            }
            return new ParkingLot(floors, parkingFees);
        }
    }

    // TODO: add exit method, which will end the parking ticket
}
