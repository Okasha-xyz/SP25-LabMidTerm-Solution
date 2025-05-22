package payment;

public class CryptoPayment implements PaymentStrategy {
    public boolean processPayment(String user, double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount + " for " + user);
        return true;
    }
}