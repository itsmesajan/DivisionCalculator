import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculator extends JFrame implements ActionListener {
  private JTextField num1Field, num2Field, resultField;
  private JButton divideButton;

  public DivisionCalculator() {
    // Create the main frame
    setTitle("Division Calculator");
    setSize(300, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(4, 2));

    // Create input fields
    JLabel num1Label = new JLabel("Enter the first number:");
    num1Field = new JTextField();
    JLabel num2Label = new JLabel("Enter the second number:");
    num2Field = new JTextField();

    // Create the result field (output)
    JLabel resultLabel = new JLabel("Result:");
    resultField = new JTextField();
    resultField.setEditable(false);

    // Create the divide button
    divideButton = new JButton("Divide");
    divideButton.addActionListener(this);

    // Add components to the frame
    add(num1Label);
    add(num1Field);
    add(num2Label);
    add(num2Field);
    add(resultLabel);
    add(resultField);
    add(divideButton);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == divideButton) {
      try {
        // Get the values from text fields
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());

        // Check for division by zero
        if (num2 == 0) {
          resultField.setText("Cannot divide by zero");
        } else {
          // Perform the division
          double result = num1 / num2;
          resultField.setText(Double.toString(result));
        }
      } catch (NumberFormatException ex) {
        resultField.setText("Invalid input");
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new DivisionCalculator());
  }
}
