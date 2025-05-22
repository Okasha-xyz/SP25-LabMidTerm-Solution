package payment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JFrame {

    private JTextField userField, amountField;
    private JComboBox<String> methodCombo;
    private JTextArea outputArea;

    public PaymentGUI() {
        setTitle("Auction Payment Processor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 100, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(130, 20, 200, 25);
        add(userField);

        JLabel amountLabel = new JLabel("Amount ($):");
        amountLabel.setBounds(20, 60, 100, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(130, 60, 200, 25);
        add(amountField);

        JLabel methodLabel = new JLabel("Payment Method:");
        methodLabel.setBounds(20, 100, 120, 25);
        add(methodLabel);

        String[] methods = {"creditcard", "paypal", "crypto"};
        methodCombo = new JComboBox<>(methods);
        methodCombo.setBounds(150, 100, 180, 25);
        add(methodCombo);

        JButton payButton = new JButton("Process Payment");
        payButton.setBounds(100, 140, 180, 30);
        add(payButton);

        outputArea = new JTextArea();
        outputArea.setBounds(20, 180, 340, 70);
        outputArea.setEditable(false);
        add(outputArea);

        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });
    }

    private void processPayment() {
        String user = userField.getText();
        String amountText = amountField.getText();
        String method = (String) methodCombo.getSelectedItem();

        try {
            double amount = Double.parseDouble(amountText);
            PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(method);
            PaymentProcessor processor = PaymentProcessor.getInstance();

            outputArea.setText("🔄 Initiating payment...\n");
            boolean success = processor.pay(user, amount, strategy);
            outputArea.append(success ? "Payment successful!" : "Payment failed.");
        } catch (NumberFormatException nfe) {
            outputArea.setText("Invalid amount.");
        } catch (IllegalArgumentException iae) {
            outputArea.setText("Invalid " + iae.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaymentGUI gui = new PaymentGUI();
            gui.setVisible(true);
        });
    }
}