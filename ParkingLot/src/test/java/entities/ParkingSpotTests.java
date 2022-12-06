package entities;

import org.example.entities.Color;
import org.example.entities.ParkingSpot;
import org.example.entities.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingSpotTests {

    @Test
    void canParkCarInCarSpot() {
        var spot = new ParkingSpot(1, Vehicle.Type.CAR, null);
        var car = new Vehicle("ABC123", Vehicle.Type.CAR, Color.GREEN, "Maruti", "Alto");

        assertTrue(spot.park(car));
    }

    @Test
    void cannotParkCarInBikeSpot() {
        var spot = new ParkingSpot(1, Vehicle.Type.MOTORBIKE, null);
        var car = new Vehicle("ABC123", Vehicle.Type.CAR, Color.GREEN, "Maruti", "Alto");

        assertFalse(spot.park(car));
    }
}
