package SpringTesting;
import java.util.Optional;
import java.util.NoSuchElementException;
public class UserService {
    private final UserRepository userRepository;

    // Constructor injection for clean mocking
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null); // [cite: 134]
    }

    // Used in Exercise 5 [cite: 161]
    public User saveUser(User user) {
        return userRepository.save(user); // [cite: 163]
    }

    // Used in Exercise 6 [cite: 166]
    public User getUserOrThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }
}
