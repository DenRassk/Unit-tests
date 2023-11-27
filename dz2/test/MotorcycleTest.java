import dz2.vehiche.Motorcycle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    private Motorcycle moto;

    @BeforeEach
    void testMoto(){
        moto = new Motorcycle("Ява", "250", 1965);
    }

    @AfterEach
    void testMotoNull(){
        moto = null;
    }

    @Test
    void testDrive() {
        moto.testDrive();
        assertEquals(75, moto.getSpeed());
    }

    @Test
    void park() {
        moto.testDrive();
        assertEquals(75, moto.getSpeed());
        moto.park();
        assertEquals(0, moto.getSpeed());
    }

    @Test
    void getNumWheels() {
        assertEquals(2, moto.getNumWheels());
    }

}