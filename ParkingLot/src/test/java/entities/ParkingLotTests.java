package entities;

import org.example.entities.ParkingFloor;
import org.example.entities.ParkingLot;
import org.example.entities.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTests {

    @Test
    void canBuildParkingLot() {
        var floorBuilder = new ParkingFloor.Builder()
                .addSpots(Vehicle.Type.CAR, 10)
                .addSpots(Vehicle.Type.MOTORBIKE, 20);

        var parkingLot = new ParkingLot.Builder(2)
                .addFloor(floorBuilder.setNumber(0).build())
                .addFloor(floorBuilder.setNumber(1).build())
                .setDefaultParkingFees(30)
                .build();

        assertNotNull(parkingLot);
    }
}
