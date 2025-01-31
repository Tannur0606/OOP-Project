import java.time.LocalDateTime;

public class Order {
    private int id;
    private User user;
    private LocalDateTime orderDate;

    public Order(int id, User user, LocalDateTime orderDate) {
        this.id = id;
        this.user = user;
        this.orderDate = orderDate;
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public LocalDateTime getOrderDate() { return orderDate; }

    @Override
    public String toString() {
        return "Order{id=" + id + ", user=" + user.getName() + ", orderDate=" + orderDate + "}";
    }
}