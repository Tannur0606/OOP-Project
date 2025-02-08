public class Admin extends User {
    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password, "ADMIN");
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin: " + getName());
    }
}
