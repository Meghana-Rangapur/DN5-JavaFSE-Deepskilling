package SpringTesting;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
public class CustomQueryRepositoryTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testFindByNameQuery() {
        UserRepository mockRepo = mock(UserRepository.class);
        List<User> mockResult = Arrays.asList(new User(1L, "Meghana"), new User(2L, "Meghana"));

        // Stub custom search function [cite: 172]
        when(mockRepo.findByName("Meghana")).thenReturn(mockResult);

        List<User> out = mockRepo.findByName("Meghana");
        assertEquals(2, out.size());
        assertEquals("Meghana", out.get(0).getName());
    }
}
