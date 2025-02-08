public class Customer extends User {
    public Customer(int id, String name, String email, String password) {
        super(id, name, email, password, "CUSTOMER"); // Добавили роль "CUSTOMER"
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer: " + getName());
    }
}
