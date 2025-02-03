import java.util.ArrayList;
import java.util.List;


public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private boolean isPaid;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.isPaid = false;
    }

    public void addProduct(Product product) {
        try {
            if (product.getQuantity() <= 0) { // Заменено getStock() -> getQuantity()
                throw new IllegalArgumentException("Product out of stock!");
            }
            products.add(product);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public void processPayment() {
        try {
            if (isPaid) {
                throw new IllegalStateException("Order is already paid!");
            }
            isPaid = true;
            System.out.println("Payment processed successfully!");
        } catch (IllegalStateException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }
}
