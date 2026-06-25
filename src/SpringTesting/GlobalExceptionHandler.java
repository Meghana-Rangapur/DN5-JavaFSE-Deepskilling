package SpringTesting;
import java.util.NoSuchElementException;
public class GlobalExceptionHandler {
    public String handleNotFound(NoSuchElementException ex) { // [cite: 181, 183]
        return "Error 404: User not found"; // [cite: 185]
    }
}
