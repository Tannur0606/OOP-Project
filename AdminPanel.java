import java.util.List;
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
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Users");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageProducts();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    System.out.println("Exiting admin panel.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void manageProducts() {
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void manageUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
