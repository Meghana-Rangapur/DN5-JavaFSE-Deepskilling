package SpringTesting;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class IntegrationTest {
    @Test
    public void testFullFlowFromControllerToDatabase() {
        // Connect real layers together without mocks
        UserRepository realRepo = new RealUserRepository();
        UserService service = new UserService(realRepo);
        UserController controller = new UserController(service);

        // 1. Call POST to save via controller
        User user = new User(null, "Charlie");
        User saved = controller.createUser(user);

        // 2. Verify it made it completely down into the database
        User fetched = controller.getUser(saved.getId());
        assertNotNull(fetched);
        assertEquals("Charlie", fetched.getName());
    }
}
