package SL4JLogging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Logging an explicit structural error situation
        logger.error("This is an error message"); // [cite: 308]

        // Logging a potential issue threat level warning
        logger.warn("This is a warning message"); // [cite: 309]
    }
}
