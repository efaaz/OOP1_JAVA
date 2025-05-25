import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field;
    private JButton addBtn, subBtn, mulBtn, divBtn;
    private JLabel resultLabel;

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        addBtn = new JButton("Add (+)");
        subBtn = new JButton("Subtract (-)");
        mulBtn = new JButton("Multiply (*)");
        divBtn = new JButton("Divide (/)");

        add(new JLabel("Enter First Number:"));
        add(num1Field);
        add(new JLabel("Enter Second Number:"));
        add(num2Field);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(subBtn);
        buttonPanel.add(mulBtn);
        buttonPanel.add(divBtn);
        add(buttonPanel);

        add(resultLabel);

        // Add action listeners
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText().trim());
            double num2 = Double.parseDouble(num2Field.getText().trim());
            double result = 0;

            if (e.getSource() == addBtn) {
                result = num1 + num2;
            } else if (e.getSource() == subBtn) {
                result = num1 - num2;
            } else if (e.getSource() == mulBtn) {
                result = num1 * num2;
            } else if (e.getSource() == divBtn) {
                if (num2 == 0) {
                    resultLabel.setText("Error: Divide by 0");
                    return;
                }
                result = num1 / num2;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input! Use numbers.");
        }
    }
}