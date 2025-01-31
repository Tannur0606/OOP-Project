    import java.util.List;
    import java.util.Scanner;
    import java.util.Random;


    public class Main {
        private static final Scanner scanner = new Scanner(System.in);
        private static final ProductDAO productDAO = new ProductDAO();
        private static Cart cart = null;

        public static void main(String[] args) {
            User user = new Customer(1, "John Doe", "john@example.com", "password123");
            cart = new Cart(user);

            while (true) {
                System.out.println("\nOnline Shop Management System");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. View Cart");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> viewAllProducts();
                    case 3 -> viewCart();
                    case 4 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private static void addProduct() {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter category: ");
            String category = scanner.nextLine();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Product product = new Product(new Random().nextInt(1000), name, category, quantity, price);
            try {
                productDAO.addProduct(product);
                cart.addProduct(product, quantity);
                System.out.println("Product added successfully.");
            } catch (Exception e) {
                System.out.println("Failed to add product: " + e.getMessage());
            }
        }

        private static void viewAllProducts() {
            List<Product> products = productDAO.getAllProducts();
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

        private static void viewCart() {
            System.out.println(cart);
            System.out.printf("Total Price: %.2f\n", cart.getTotalPrice());
        }
    }

