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
            System.out.println("\n--- Admin Panel ---");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. View All Products");
            System.out.println("4. Add Product");
            System.out.println("5. Delete Product");
            System.out.println("6. View Orders");
            System.out.println("7. Manage Payments");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewAllUsers();
                case 2 -> deleteUser();
                case 3 -> productService.viewAllProducts();
                case 4 -> addProduct();
                case 5 -> deleteProduct();
                case 6 -> viewOrders();
                case 7 -> managePayments();
                case 8 -> {
                    System.out.println("Exiting Admin Panel...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void viewAllUsers() {
        System.out.println("\nAll Registered Users:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user.getId() + " | " + user.getName() + " | " + user.getEmail() + " | " + user.getRole());
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

        productService.addProduct(new Product(0, name, category, quantity, price));
        System.out.println("Product added successfully.");
    }
    private void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID to delete: ");
        int id = scanner.nextInt();

        if (userService.deleteUser(id)) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Failed to delete user. User not found.");
        }
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        if (productService.deleteProduct(id)) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Failed to delete product. Product not found.");
        }
    }
    private void viewOrders() {
        System.out.println("\nAll Orders:");
        var orders = userService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orders) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("User: " + order.getUser().getName());
            System.out.println("Product: " + order.getProduct().getName());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("--------------------------");
        }
    }
    private void managePayments() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter order ID to update payment method: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Choose new payment method:");
        System.out.println("1. CREDIT_CARD");
        System.out.println("2. DEBIT_CARD");
        System.out.println("3. PAYPAL");
        System.out.println("4. CASH_ON_DELIVERY");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        Payments.PaymentMethod newMethod;
        switch (paymentChoice) {
            case 1 -> newMethod = Payments.PaymentMethod.CREDIT_CARD;
            case 2 -> newMethod = Payments.PaymentMethod.DEBIT_CARD;
            case 3 -> newMethod = Payments.PaymentMethod.PAYPAL;
            case 4 -> newMethod = Payments.PaymentMethod.CASH_ON_DELIVERY;
            default -> {
                System.out.println("Invalid payment method. Operation aborted.");
                return;
            }
        }

        if (userService.updatePaymentMethod(orderId, newMethod)) {
            System.out.println("Payment method updated successfully.");
        } else {
            System.out.println("Failed to update payment method. Order not found.");
        }
    }
}
