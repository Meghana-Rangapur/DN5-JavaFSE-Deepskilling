package MockitoDependencies;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class UserIntegrationTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testFullFlowWithMockedServiceLayer() {
        // 1. Mock the backend service layer component
        MockDepUserService mockService = mock(MockDepUserService.class);

        // 2. Setup the mock behavior
        User automatedUser = new User(100L, "Integration Test User");
        when(mockService.getUserById(100L)).thenReturn(automatedUser);

        // 3. Inject the mock service into the controller component
        MockDepIntegrationController controller = new MockDepIntegrationController(mockService);

        // 4. Execute the endpoint entry point flow
        User response = controller.getUserEndpoint(100L);

        // 5. Validate the whole chain matches perfectly
        assertNotNull(response);
        assertEquals("Integration Test User", response.getName());
        verify(mockService).getUserById(100L);
    }
}
