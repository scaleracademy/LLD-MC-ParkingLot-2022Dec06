package entities;

import org.example.entities.Color;
import org.example.entities.ParkingFloor;
import org.example.entities.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingFloorTests {

    @Test
    void canCreateAParkingFloor() {
        var builder = new ParkingFloor.Builder();

        builder.addSpots(Vehicle.Type.CAR, 10);
        builder.addSpots(Vehicle.Type.MOTORBIKE, 5);

        var floor1 = builder.setNumber(1).build();
        var floor2 = builder.setNumber(2).build();
        var floor3 = builder.setNumber(3).build();

        assertNotNull(floor1);
    }

    @Test
    void throwsErrorOnBuildingFloorWithoutNumber() {
        assertThrows(IllegalStateException.class, () -> {
            new ParkingFloor.Builder().build();
        });
    }

    @Test
    void canFindFirstFreeSpot() {
        var builder = new ParkingFloor.Builder();

        builder.addSpots(Vehicle.Type.CAR, 10);
        builder.addSpots(Vehicle.Type.MOTORBIKE, 5);

        var floor1 = builder.setNumber(1).build();

        assertEquals(0, floor1.getFirstFreeSpot(Vehicle.Type.CAR));

        var car = new Vehicle("ABC123", Vehicle.Type.CAR, Color.RED, "BMW", "X5");
        floor1.park(car);
        // floor1.park(car); // TODO: handle errors for parking same car in same parking twice

        assertEquals(1, floor1.getFirstFreeSpot(Vehicle.Type.CAR));

    }
}
