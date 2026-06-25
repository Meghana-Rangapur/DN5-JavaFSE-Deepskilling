package SL4JLogging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String username = "User";
        int loginAttempts = 3;

        // Parameterized logging using {} anchors
        logger.info("User '{}' successfully logged in after {} attempts.", username, loginAttempts);

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred during calculation for user '{}':", username, e);
        }
    }
}
