package MockitoAdvanced;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ServiceTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testServiceWithMockRepository() {
        // 1. Create a fake version of the Repository
        Repository mockRepository = mock(Repository.class);

        // 2. Script the mock to return "Mock Data"
        when(mockRepository.getData()).thenReturn("Mock Data");

        // 3. Hand the mock to your service
        Service service = new Service(mockRepository);

        // 4. Run the service action
        String result = service.processData();

        // 5. Verify the business logic correctly attached "Processed "
        assertEquals("Processed Mock Data", result);
    }
}
