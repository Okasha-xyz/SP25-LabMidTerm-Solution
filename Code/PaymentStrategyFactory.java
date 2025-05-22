package payment;

public class PaymentStrategyFactory {
    public static PaymentStrategy getStrategy(String method) {
        switch (method.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
            case "paypal":
                return new PayPalPayment();
            case "crypto":
                return new CryptoPayment();
            default:
                throw new IllegalArgumentException("Unsupported payment method: " + method);
        }
    }
}