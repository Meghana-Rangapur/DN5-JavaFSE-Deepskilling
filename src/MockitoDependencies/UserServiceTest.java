package MockitoDependencies;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Optional;
public class UserServiceTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testServiceWithMockRepository() {
        // 1. Create a fake mock version of the UserRepository
        UserRepository mockRepo = mock(UserRepository.class);

        // 2. Script the mock to return a User when findById(5L) is triggered
        User sampleUser = new User(5L, "Meghana Rangapur");
        when(mockRepo.findById(5L)).thenReturn(Optional.of(sampleUser));

        // 3. Hand the mock repository directly into your service
        MockDepUserService service = new MockDepUserService(mockRepo);

        // 4. Run the service action
        User result = service.getUserById(5L);

        // 5. Assert the service layer handles the data correctly
        assertNotNull(result);
        assertEquals("Meghana Rangapur", result.getName());

        // Verify the interaction occurred
        verify(mockRepo).findById(5L);
    }
}
