package org.example.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingLot {

    List<ParkingFloor> floors;

    public static class Builder {
        private int numFloors;
        List<ParkingFloor> floors;

        public Builder(int numFloors) {
            this.numFloors = numFloors;
            this.floors = new ArrayList<>(numFloors);
        }

        public Builder addFloor(ParkingFloor floor) {
            if (floors.size() == numFloors) {
                System.out.println("Cannot add more floors");
                return this;
            }
            floors.add(floor);
            return this;
        }

        public ParkingLot build() {
            if (floors.size() < numFloors) {
                throw new IllegalStateException("All floors are not defined");
            }
            return new ParkingLot(floors);
        }
    }
}
