package entities;

import org.example.entities.ParkingFloor;
import org.example.entities.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingFloorTests {

    @Test
    void canCreateAParkingFloor() {
        var builder = new ParkingFloor.Builder(1);

        builder.addSlots(Vehicle.Type.CAR, 10);
        builder.addSlots(Vehicle.Type.MOTORBIKE, 5);

        var floor1 = builder.build();
        var floor2 = builder.setNumber(2).build();
        var floor3 = builder.setNumber(3).build();


        assertNotNull(floor1);
    }
}
