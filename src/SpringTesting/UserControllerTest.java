package SpringTesting;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class UserControllerTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testGetEndpoint_Exercise3() {
        UserService mockService = mock(UserService.class);
        when(mockService.getUserById(10L)).thenReturn(new User(10L, "Alice"));

        UserController controller = new UserController(mockService);
        User response = controller.getUser(10L);

        assertEquals("Alice", response.getName());
    }

    @Test
    public void testPostEndpoint_Exercise5() {
        UserService mockService = mock(UserService.class);
        User inputUser = new User(null, "Bob");
        User savedUser = new User(2L, "Bob");

        when(mockService.saveUser(inputUser)).thenReturn(savedUser);

        UserController controller = new UserController(mockService);
        User response = controller.createUser(inputUser);

        assertNotNull(response.getId());
        assertEquals("Bob", response.getName());
    }
}
