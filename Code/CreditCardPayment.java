package payment;

public class CreditCardPayment implements PaymentStrategy {
    
    public boolean processPayment(String user, double amount) {
        System.out.println("Processing credit card payment of $" + amount + " for " + user);
        return true;
    }
}