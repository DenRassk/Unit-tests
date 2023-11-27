import dz2.vehiche.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void testCar(){
        car = new Car("Жигули", "2108", 1995);
    }

    @AfterEach
    void testCarNull() {
        car = null;
    }

    @Test
    void testDrive() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    void park() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    void getNumWheels() {
        assertEquals(4, car.getNumWheels());
    }

}