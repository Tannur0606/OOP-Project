import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final User user;
    private final Map<Product, Integer> items;

    public Cart(User user) {
        this.user = user;
        this.items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public void clearCart() {
        items.clear();
    }

    public double getTotalPrice() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{user=" + user.getName() + ", items=" + items + "}";
    }
}
