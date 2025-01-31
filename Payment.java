import java.time.LocalDateTime;

public class Payment {
    public enum PaymentStatus { PENDING, COMPLETED, FAILED }
    public enum PaymentMethod { CREDIT_CARD, DEBIT_CARD, PAYPAL, CASH_ON_DELIVERY }

    private int id;
    private User user;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime paymentDate;

    public Payment(int id, User user, double amount, PaymentMethod method) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
        this.paymentDate = LocalDateTime.now();
    }

    public void completePayment() {
        this.status = PaymentStatus.COMPLETED;
    }

    public void failPayment() {
        this.status = PaymentStatus.FAILED;
    }

    @Override
    public String toString() {
        return "Payment{id=" + id + ", user=" + user.getName() + ", amount=" + amount + ", method=" + method + ", status=" + status + ", paymentDate=" + paymentDate + "}";
    }
}