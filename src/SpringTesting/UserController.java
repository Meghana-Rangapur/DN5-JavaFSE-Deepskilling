package SpringTesting;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Exercise 3 Endpoint [cite: 146]
    public User getUser(Long id) {
        return userService.getUserById(id); // [cite: 148]
    }

    // Exercise 5 Endpoint [cite: 160]
    public User createUser(User user) {
        return userService.saveUser(user); // [cite: 163]
    }
}
