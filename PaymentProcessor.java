package payment;

public class PaymentProcessor {
    private static PaymentProcessor instance;

    private PaymentProcessor() {
    }

    public static PaymentProcessor getInstance() {
        if (instance == null) {
            instance = new PaymentProcessor();
        }
        return instance;
    }

    public boolean pay(String user, double amount, PaymentStrategy strategy) {
        System.out.println("Initiating payment...");
        boolean success = strategy.processPayment(user, amount);
        if (success) {
            System.out.println("Payment successful!\n");
        } else {
            System.out.println("Payment failed.\n");
        }
        return success;
    }
}