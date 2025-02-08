import java.time.LocalDateTime;

public class Payments {

    public enum PaymentMethod {
        CREDIT_CARD, DEBIT_CARD, PAYPAL, CASH_ON_DELIVERY
    }

    private int id;
    private User user;
    private double amount;
    private PaymentMethod method;
    private LocalDateTime paymentDate;

    public Payments(int id, User user, double amount, PaymentMethod method) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.method = method;
        this.paymentDate = LocalDateTime.now();
    }

    public void setPaymentMethod(PaymentMethod method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", amount=" + amount +
                ", method=" + method +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
