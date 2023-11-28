
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static dz3.Number.NumberCheck.*;


class NumberCheckTest {



    @ParameterizedTest
    @ValueSource(strings = {"10","15","23","46"})
    void evenOddNumberTest(int numberForTest) {

        if (numberForTest % 2 == 0) {
            assertTrue(evenOddNumber(numberForTest));
        } else {
            assertFalse(evenOddNumber(numberForTest));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestArguments.class)
    void numberInIntervalTest(int numberForTest) {

        if (numberForTest > 25 && numberForTest < 100) {
            assertTrue(numberInInterval(numberForTest));
        } else {
            assertFalse(numberInInterval(numberForTest));

        }
    }
}

class TestArguments implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(15),
                Arguments.of(23),
                Arguments.of(33),
                Arguments.of(101)
        );

    }
}