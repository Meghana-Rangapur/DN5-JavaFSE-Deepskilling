package SpringTesting;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Optional;
public class UserServiceTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testGetUserById() {
        // 1. Mock the repository dependency
        UserRepository mockRepo = mock(UserRepository.class);

        // 2. Stub the repository interaction
        User sampleUser = new User(1L, "Meghana");
        when(mockRepo.findById(1L)).thenReturn(Optional.of(sampleUser));

        // 3. Inject mock into service and assert
        UserService service = new UserService(mockRepo);
        User result = service.getUserById(1L);

        assertNotNull(result);
        assertEquals("Meghana", result.getName());
    }
}
