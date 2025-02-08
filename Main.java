import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;



public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductService productService = new ProductService();
    private static final UserService userService = new UserService();
    private static Cart cart;
    public static void main(String[] args) {
        User admin = new Customer(3, "Tannur", "twix@gmail.com", "123");
        cart = new Cart(admin);

        AdminPanel adminPanel = new AdminPanel(productService, userService);

        while (true) {
            System.out.println("\n=== Online Shop Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Add User");
            System.out.println("4. View All Users");
            System.out.println("5. Create Order");
            System.out.println("6. View Orders");
            System.out.println("7. Manage Payments");
            System.out.println("8. Add to Cart");
            System.out.println("9. View Cart");
            System.out.println("10. Admin Panel");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> addUser();
                case 4 -> viewUsers();
                case 5 -> createOrder();
                case 6 -> viewOrders();
                case 7 -> managePayments();
                case 8 -> addToCart();
                case 9 -> viewCart();
                case 10 -> adminPanel.displayAdminMenu();
                case 11 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        int id = productService.generateProductId();
        Product product = new Product(id, name, category, quantity, price);
        productService.addProduct(product);

        System.out.println("Product added successfully!");
    }

    private static void viewProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\n=== Product List ===");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void addUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        int id = userService.generateUserId();
        User user = new Customer(id, name, email, password);
        userService.addUser(user);

        System.out.println("User added successfully!");
    }

    private static void viewUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        System.out.println("\n=== User List ===");
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void createOrder() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add items before creating an order.");
            return;
        }

        System.out.println("Creating order from cart...");

        System.out.println("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        User user = userService.getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        int orderId = userService.generateOrderId();

        List<Product> cartItems = cart.getItems();
        for (Product product : cartItems) {
            System.out.println("Processing product: " + product.getName());

            System.out.println("Enter quantity for " + product.getName() + ": ");
            int quantityInCart = scanner.nextInt();
            scanner.nextLine();

            if (quantityInCart > product.getQuantity()) {
                System.out.println("Not enough stock for " + product.getName() + ". Available: " + product.getQuantity());
                continue;
            }

            Order order = new Order(orderId, user, product, quantityInCart);
            userService.addOrder(order);

            productService.updateStock(product.getId(), quantityInCart);
        }

        cart.clearCart();
        System.out.println("Cart cleared after order creation.");
        System.out.println("Order created successfully!");
    }





    private static void viewOrders() {
        List<Order> orders = userService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        System.out.println("\n=== Orders List ===");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("User: " + order.getUser().getName());
            System.out.println("Product: " + order.getProduct().getName());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("----------");
        }
    }



    private static void managePayments() {
        System.out.println("Enter user ID for payment: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        User user = userService.getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Select payment method: ");
        System.out.println("1. CREDIT_CARD");
        System.out.println("2. DEBIT_CARD");
        System.out.println("3. PAYPAL");
        System.out.println("4. CASH_ON_DELIVERY");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        Payments.PaymentMethod method;
        switch (paymentChoice) {
            case 1 -> method = Payments.PaymentMethod.CREDIT_CARD;
            case 2 -> method = Payments.PaymentMethod.DEBIT_CARD;
            case 3 -> method = Payments.PaymentMethod.PAYPAL;
            case 4 -> method = Payments.PaymentMethod.CASH_ON_DELIVERY;
            default -> {
                System.out.println("Invalid payment method.");
                return;
            }
        }


        int orderId = userService.getOrderForUser(userId);

        if (orderId == -1) {
            System.out.println("No order found for this user. Please create an order first.");
            return;
        }

        System.out.println("Adding payment for order ID: " + orderId);

        String sql = "INSERT INTO payments (order_id, payment_date, amount, payment_method) VALUES (?, NOW(), ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            stmt.setDouble(2, amount);
            stmt.setString(3, method.toString());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Payment successfully recorded in the database!");
            } else {
                System.out.println("Error: Payment was not saved.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void addToCart() {
        System.out.println("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = productService.getProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        if (product.getQuantity() <= 0) {
            System.out.println("Out of stock: " + product.getName());
            return;
        }

        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock available. Maximum available: " + product.getQuantity());
            return;
        }

        cart.addItem(product, quantity);
        System.out.println("Product added to cart!");
    }



    private static void viewCart() {
        if (cart == null || cart.getItems().isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\n=== Cart Items ===");
        for (Product item : cart.getItems()) {
            System.out.println(item);
        }
        System.out.println("Total Price: " + cart.getTotalPrice());
    }
}
