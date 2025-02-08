public class Order {
    private int id;
    private User user;
    private Product product;
    private int quantity;

    public Order(int id, User user, Product product, int quantity) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }



@Override
    public String toString() {
        return "Order{" +
                "user=" + user.getName() +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
