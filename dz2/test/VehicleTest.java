import dz2.vehiche.Car;
import dz2.vehiche.Motorcycle;
import dz2.vehiche.Vehicle;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {


    @ParameterizedTest
    @ArgumentsSource(TestVehicle.class)
    void testDrive(Vehicle vehicle) {
        if (vehicle instanceof Car){
            vehicle.testDrive();
            assertEquals(60, ((Car) vehicle).getSpeed());
        } else if (vehicle instanceof Motorcycle) {
            vehicle.testDrive();
            assertEquals(75, ((Motorcycle) vehicle).getSpeed());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestVehicle.class)
    void park(Vehicle vehicle) {
        if (vehicle instanceof Car){
            vehicle.testDrive();
            assertEquals(60, ((Car) vehicle).getSpeed());
            vehicle.park();
            assertEquals(0, ((Car) vehicle).getSpeed());
        } else if (vehicle instanceof Motorcycle) {
            vehicle.testDrive();
            assertEquals(75, ((Motorcycle) vehicle).getSpeed());
            vehicle.park();
            assertEquals(0, ((Motorcycle) vehicle).getSpeed());
        }
    }
}

class TestVehicle implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new Car("Жигули", "2109", 1997)),
                Arguments.of(new Motorcycle("Урал", "М-67", 1975))
        );

    }
}