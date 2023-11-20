package TipCalculator;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TipCalculatorGUI {
    private JFrame frame;
    private JTextField totalTextField;
    private JTextField percentageTextField;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JButton clearButton;
    private JButton[] percentageButtons;

    public TipCalculatorGUI() {
        frame = new JFrame("Tip Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        totalTextField = new JTextField(10);
        percentageTextField = new JTextField(10);
        // Buttons for set tip percentages 
        String[] percentages = {"5%", "10%", "15%", "20%"};
        percentageButtons = new JButton[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            percentageButtons[i] = new JButton(percentages[i]);
        }
        
        calculateButton = new JButton("Calculate Tip");
        clearButton = new JButton("Clear");
        resultLabel = new JLabel("Total amount with tip will be displayed here");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Total Amount:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(totalTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Tip Percentage:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(percentageTextField, gbc);


        // New row for percentage buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        for (JButton button : percentageButtons) {
            buttonPanel.add(button);
        }

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span across two columns
        panel.add(buttonPanel, gbc);

        // Reset grid position
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Reset grid width
        panel.add(calculateButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(clearButton, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Span across two columns for the result label
        panel.add(resultLabel, gbc);
    
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        for (JButton button : percentageButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    percentageTextField.setText(button.getText());
                }
            });
        }
        frame.add(panel);
        frame.setVisible(true);
    }

        private void calculateTotal() {
            try {
                double totalAmount = Double.parseDouble(totalTextField.getText());
                String selectedPercentage = percentageTextField.getText();
                double selectedPercentageDBL = Double.parseDouble(selectedPercentage.replace("%", ""));
                double tipPercentage =  selectedPercentageDBL/ 100;
                // Calculate total with tip
                double totalWithTip = totalAmount * (1 + tipPercentage);

                // Display the result
                resultLabel.setText(String.format("Total amount with %.2f%% tip: $%.2f", selectedPercentageDBL, totalWithTip));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter valid numbers.");
            }
        }

    private void clearFields() {
        totalTextField.setText("");
        percentageTextField.setText("");
        resultLabel.setText("<html>Tip amount: $0.00<br>Your new total will be $0.00</html>");
    }


 
}

