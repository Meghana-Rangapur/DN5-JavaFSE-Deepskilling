package SpringTesting;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class ParameterizedCalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "1,  2,  3",   // a=1, b=2, expected=3
            "5,  5,  10",  // a=5, b=5, expected=10
            "12, 8,  20"   // a=12, b=8, expected=20
    })
    public void testMultipleAdditions(int a, int b, int expectedResult) {
        CalculatorService service = new CalculatorService();
        assertEquals(expectedResult, service.add(a, b));
    }
}
