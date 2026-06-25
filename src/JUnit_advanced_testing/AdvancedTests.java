package JUnit_advanced_testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 3: Setting explicit test execution order by index
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdvancedTests {

    // Exercise 1: Parameterized Test running multiple inputs through one method
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @Order(1) // Runs first
    public void testIsEven(int number) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(number));
    }

    // Exercise 4: Validating that an expected exception is explicitly thrown
    @Test
    @Order(2) // Runs second
    public void testException() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
    }

    // Exercise 5: Performance testing to verify task finishes within a time limit
    @Test
    @Order(3) // Runs third
    public void testTimeout() {
        PerformanceTester tester = new PerformanceTester();

        // Verifies the method completes in under 500 milliseconds
        assertTimeout(Duration.ofMillis(500), () -> {
            tester.performTask();
        });
    }
}