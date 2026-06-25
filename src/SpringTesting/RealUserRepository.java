package SpringTesting;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class RealUserRepository implements UserRepository{
    private final Map<Long, User> db = new HashMap<>();
    private long idSequence = 1;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idSequence++);
        }
        db.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> results = new ArrayList<>();
        for (User u : db.values()) {
            if (u.getName().equalsIgnoreCase(name)) results.add(u);
        }
        return results;
    }
}
