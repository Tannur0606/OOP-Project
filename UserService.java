import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Method to delete a user by ID
    public boolean deleteUserById(int id) {
        User user = getUserById(id);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    // Method to get the next user ID
    public int getNextUserId() {
        if (users.isEmpty()) {
            return 1; // Starting ID
        } else {
            return users.get(users.size() - 1).getId() + 1; // Increment the last user's ID
        }
    }
}
