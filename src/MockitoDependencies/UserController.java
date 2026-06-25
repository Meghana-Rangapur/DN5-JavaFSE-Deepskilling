package MockitoDependencies;

public class UserController {
    private final UserService userService;

    // Constructor injection for clean testing without complex frameworks
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUser(Long id) {
        return userService.getUserById(id);
    }

}
