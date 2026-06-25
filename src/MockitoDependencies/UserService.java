package MockitoDependencies;

public class UserService {
    public User getUserById(Long id) {
        return new User(id, "Real Production User");
    }
}
