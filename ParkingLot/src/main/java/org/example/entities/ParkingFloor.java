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

    public Map<Vehicle.Type, Integer> emptySpots() {
        Map<Vehicle.Type, Integer> emptySpots = new HashMap<>();
        parkingSpots.entrySet().forEach(vehicleType -> {
            int thisTypeEmptySpots = 0;
            for (ParkingSpot spot : vehicleType.getValue()) {
                if (!spot.isOccupied()) {
                    thisTypeEmptySpots++;
                }
            }
            emptySpots.put(vehicleType.getKey(), thisTypeEmptySpots);
        });
        return emptySpots;
    }

    /**
     * @param type type of vehicle for which we want to find empty slot
     * @return the nearest empty slot (or -1 if no empty slot)
     */
    public int getFirstFreeSpot(Vehicle.Type type) {
        List<ParkingSpot> spots = parkingSpots.get(type);
        for (int i = 0; i < spots.size(); i++) {
            if (!spots.get(i).isOccupied()) {
                return i;
            }
        }
        return -1;
    }

    public boolean park(Vehicle vehicle) {
        int spotNumber = getFirstFreeSpot(vehicle.type);
        if (spotNumber == -1) {
            System.out.println("No empty spot for " + vehicle.type);
            return false;
        }
        ParkingSpot spot = parkingSpots.get(vehicle.type).get(spotNumber);
        return spot.park(vehicle);
    }

    public static class Builder {
        Integer number;
        Map<Vehicle.Type, Integer> spotCapacity;

        public Builder() {
            this.spotCapacity = new HashMap<>();
        }

        public Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        public Builder addSpots(Vehicle.Type type, int capacity) {
            spotCapacity.put(type, capacity);
            return this;
        }

        public ParkingFloor build() {
            if (number == null) {
                throw new IllegalStateException("Floor number is not set");
            }

            Map<Vehicle.Type, List<ParkingSpot>> parkingSpots = new HashMap<>();

            for (Map.Entry<Vehicle.Type, Integer> entry : spotCapacity.entrySet()) {
                parkingSpots.put(entry.getKey(), ParkingSpot.createSpots(entry.getKey(), entry.getValue()));
            }
            return new ParkingFloor(number, parkingSpots);
        }

    }

    // TODO: add exit method  (inside that, free up emptyspots +1)
    // TODO: add entry method (inside that, emptyspots should reduce)

}
