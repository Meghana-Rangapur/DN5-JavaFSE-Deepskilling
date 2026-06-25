package SpringTesting;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CalculatorServiceTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testAdd() {
        CalculatorService service = new CalculatorService();
        int result = service.add(5, 10);
        assertEquals(15, result);
    }
}
