package org.example.entities;

import java.util.Date;

public class ParkingTicket {

    Date startTime;
    Date endTime;
    Vehicle vehicle;
    ParkingSpot spot;
    ParkingLot lot;

    public boolean isActive() {
        return endTime == null;
    }

    public ParkingTicket(Date startTime, Vehicle vehicle, ParkingSpot spot, ParkingLot lot) {
        this.startTime = startTime;
        this.vehicle = vehicle;
        this.spot = spot;
        this.lot = lot;
    }

    /**
     * TODO: call this method when car exits
     *
     * @return the total parking bill to be paid
     */
    public int endParking() {
        this.endTime = new Date();

        long diff = endTime.getTime() - startTime.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        int diffHours = Math.toIntExact(diff / (60 * 60 * 1000) % 24);
        var fees = this.lot.parkingFees.get(vehicle.type);

        return fees * diffHours;
    }
}
