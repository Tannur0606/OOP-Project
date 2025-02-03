import java.util.List;
import java.util.Scanner;
import java.util.Random;



public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductDAO productDAO = new ProductDAO();
    private static final ProductService productService = new ProductService();
    private static final UserService userService = new UserService();
    private static Cart cart = null;

    public static void main(String[] args) {
        // Create a user for demonstration
        User user = new Customer(1, "Tangnur", "tannurka0606@gmail.com", "123123");
        cart = new Cart(user);

        // Create AdminPanel
        AdminPanel adminPanel = new AdminPanel(productService, userService);

        while (true) {
            System.out.println("\nOnline Shop Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. View Cart");
            System.out.println("4. Admin Panel");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewAllProducts();
                case 3 -> viewCart();
                case 4 -> {
                    System.out.println("Entering Admin Panel...");
                    adminPanel.displayAdminMenu();
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addProduct() {
        // Same code as before
    }

    private static void viewAllProducts() {
        // Same code as before
    }

    private static void viewCart() {
        // Same code as before
    }
}
