package SpringTesting;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.NoSuchElementException;
public class ExceptionHandlingTest {
    static {
        System.setProperty("net.bytebuddy.experimental", "true");
    }

    @Test
    public void testServiceException_Exercise6() {
        UserRepository mockRepo = mock(UserRepository.class);
        // Simulate missing record returning empty configuration [cite: 166]
        when(mockRepo.findById(99L)).thenReturn(Optional.empty());

        UserService service = new UserService(mockRepo);

        assertThrows(NoSuchElementException.class, () -> {
            service.getUserOrThrow(99L);
        });
    }

    @Test
    public void testControllerAdviceHandler_Exercise8() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();
        NoSuchElementException ex = new NoSuchElementException("User not found"); // [cite: 181, 185]

        String responseBody = exceptionHandler.handleNotFound(ex);
        assertEquals("Error 404: User not found", responseBody); // [cite: 185]
    }
}
