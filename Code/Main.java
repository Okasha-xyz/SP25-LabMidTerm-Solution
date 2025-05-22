package payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to Auction Payment Processor");
        System.out.print("Enter your username: ");
        String user = scanner.nextLine();

        System.out.print("Enter amount to pay: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Choose payment method (creditcard, paypal, crypto): ");
        String method = scanner.nextLine();

        try {
            PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(method);
            PaymentProcessor processor = PaymentProcessor.getInstance();
            processor.pay(user, amount, strategy);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}