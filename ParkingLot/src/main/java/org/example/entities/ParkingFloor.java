package org.example.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ParkingFloor {

    int number;
    Map<Vehicle.Type, List<ParkingSpot>> parkingSpots;


    public static class Builder {
        int number;
        Map<Vehicle.Type, Integer> spotCapacity;

        public Builder(int number) {
            this.number = number;
            this.spotCapacity = new HashMap<>();
        }

        public Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        public Builder addSlots(Vehicle.Type type, int capacity) {
            spotCapacity.put(type, capacity);
            return this;
        }

        public ParkingFloor build() {
            Map<Vehicle.Type, List<ParkingSpot>> parkingSpots = new HashMap<>();

            for (Map.Entry<Vehicle.Type, Integer> entry : spotCapacity.entrySet()) {
                parkingSpots.put(entry.getKey(), ParkingSpot.createSpots(entry.getKey(), entry.getValue()));
            }
            return new ParkingFloor(number, parkingSpots);
        }

    }

}
