package payment;

public interface PaymentStrategy {
    boolean processPayment(String user, double amount);
}