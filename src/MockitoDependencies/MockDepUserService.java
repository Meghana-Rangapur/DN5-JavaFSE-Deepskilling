package MockitoDependencies;

public class MockDepUserService {
    private final UserRepository userRepository;

    // Constructor injection for clean Mockito testing
    public MockDepUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        // Calls the repository and returns null if not found
        return userRepository.findById(id).orElse(null);
    }
}
