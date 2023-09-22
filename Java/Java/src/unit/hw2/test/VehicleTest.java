import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.hw2.task.Car;
import unit.hw2.task.Motorcycle;
import unit.hw2.task.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Company",
                "Model",
                2023);

        motorcycle = new Motorcycle("Company",
                "Model",
                2022);
    }

    @Test
    public void vehicleTest() {
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    public void carWheelTest() {
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void motoWheelTest() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void carTestDriveTest() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void motoTestDriveTest() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    public void carParkTest() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void motoParkTest() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}
