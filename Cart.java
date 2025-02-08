import java.util.ArrayList;
import java.util.List;

public class Cart {
    private User user;
    private List<Product> items;

    public Cart(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(product);
        }
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public void clearCart() {
        items.clear();
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Product> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "user=" + user.getName() +
                ", items=" + items +
                '}';
    }
}
