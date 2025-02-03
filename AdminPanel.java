import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdminPanel {
    private final ProductService productService;
    private final UserService userService;

    public AdminPanel(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    public void displayAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Panel");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Update Product");
            System.out.println("5. View Users");
            System.out.println("6. Add User");
            System.out.println("7. Delete User");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addProduct();
                case 3 -> deleteProduct();
                case 4 -> updateProduct();
                case 5 -> viewUsers();
                case 6 -> addUser();
                case 7 -> deleteUser();
                case 8 -> {
                    System.out.println("Exiting admin panel...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("ID | Name | Category | Quantity | Price");
            for (Product product : products) {
                System.out.printf("%d | %s | %s | %d | %.2f\n",
                        product.getId(), product.getName(), product.getCategory(),
                        product.getQuantity(), product.getPrice());
            }
        }
    }

    private void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Product product = new Product(new Random().nextInt(1000), name, category, quantity, price);
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();

        boolean success = productService.deleteProductById(id);
        if (success) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Failed to delete product. Product not found.");
        }
    }

    private void updateProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new category: ");
        String category = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();

        boolean success = productService.updateProduct(id, name, category, quantity, price);
        if (success) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Failed to update product. Product not found.");
        }
    }

    private void viewUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("ID | Name | Email");
            for (User user : users) {
                System.out.printf("%d | %s | %s\n", user.getId(), user.getName(), user.getEmail());
            }
        }
    }

    private void addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(new Random().nextInt(1000), name, email, password);
        userService.addUser(user);
        System.out.println("User added successfully!");
    }

    private void deleteUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user ID to delete: ");
        int id = scanner.nextInt();

        boolean success = userService.deleteUserById(id);
        if (success) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("Failed to delete user. User not found.");
        }
    }
}
