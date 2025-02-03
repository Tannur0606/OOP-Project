public class UserFactory {
    public static User createUser(String role, int id, String name, String email, String password) {
        return switch (role) {
            case "Admin" -> new Admin(id, name, email, password);
            case "Customer" -> new Customer(id, name, email, password);
            default -> throw new IllegalArgumentException("Invalid user role");
        };
    }
}
