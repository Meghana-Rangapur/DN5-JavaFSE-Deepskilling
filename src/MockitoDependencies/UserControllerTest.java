package MockitoDependencies;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class UserControllerTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testUserControllerWithMockService() {
        // 1. Create a fake mock version of the UserService dependency
        UserService mockUserService = mock(UserService.class);

        // 2. Script the mock: when controller requests user 10, return a specific dummy user
        User mockUser = new User(10L, "Faked Test Profile");
        when(mockUserService.getUserById(10L)).thenReturn(mockUser);

        // 3. Hand the mock service into the controller
        UserController controller = new UserController(mockUserService);

        // 4. Run the controller action
        User response = controller.getUser(10L);

        // 5. Verify the controller passed the data back perfectly without touching the database
        assertNotNull(response);
        assertEquals(10L, response.getId());
        assertEquals("Faked Test Profile", response.getName());

        // Verification check: ensure the controller actually triggered the service method
        verify(mockUserService).getUserById(10L);
    }
}
