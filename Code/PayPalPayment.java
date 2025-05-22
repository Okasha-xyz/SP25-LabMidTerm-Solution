package payment;

public class PayPalPayment implements PaymentStrategy {
    public boolean processPayment(String user, double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for " + user);
        return true;
    }
}