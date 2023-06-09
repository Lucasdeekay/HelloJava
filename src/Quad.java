import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class QuadForm extends JFrame implements ActionListener {

    JFrame frame = new JFrame();

    //  Create objects
    final JLabel title = new JLabel("Quadratic Calculator");

    final JLabel infoLabel = new JLabel("Enter the values fo a, b, and c to solve your quadratic equation");

    final JLabel aLabel = new JLabel("Enter Value For a");
    final JTextField aInput = new JTextField();

    final JLabel bLabel = new JLabel("Enter Value For b");
    final JTextField bInput = new JTextField();

    final JLabel cLabel = new JLabel("Enter Value For c");
    final JTextField cInput = new JTextField();


    final JButton submitButton = new JButton("Submit");


    // constructor, to initialize the components
    // with default values.
    public QuadForm() {
        createWindow();
        setObjectLayout();
        addObjectsToFrame();
        addActionListener();
        setStyle();
    }

    void createWindow() {
        // Set form title
        frame.setTitle("Quadratic Calculator");
        // Set boundaries for the form
        frame.setBounds(300, 90, 450, 300);
        // Setting the background color
        frame.getContentPane().setBackground(Color.gray);
        // Set the default close operation
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set it to not be resizeable
        frame.setResizable(false);
        // Set layout
        frame.getContentPane().setLayout(null);
        // Make frame visible
        frame.setVisible(true);
    }

    void setObjectLayout() {
        // Set bounds for labels
        title.setBounds(150, 10, 200, 20);
        infoLabel.setBounds(130, 30, 150, 20);
        aLabel.setBounds(100, 60, 150, 20);
        bLabel.setBounds(100, 90, 150, 20);
        cLabel.setBounds(100, 120, 150, 20);

        // Set bounds for input
        aInput.setBounds(250, 60, 30, 20);
        bInput.setBounds(250, 90, 30, 20);
        cInput.setBounds(250, 120, 30, 20);

        // Set bounds for buttons
        submitButton.setBounds(170, 150, 80, 30);

    }

    void addObjectsToFrame() {
        frame.add(title);
        frame.add(infoLabel);
        frame.add(aLabel);
        frame.add(aInput);
        frame.add(bLabel);
        frame.add(bInput);
        frame.add(cLabel);
        frame.add(cInput);
        frame.add(submitButton);
    }

    void addActionListener() {
        submitButton.addActionListener(this);
    }

    void setStyle() {
        title.setFont(new Font("Arial", Font.BOLD, 15));
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
    }

    void resetObjects() {
        aInput.setText("");
        bInput.setText("");
        cInput.setText("");
    }

    boolean checkIfObjectsEmpty() {
        if (aInput.getText().isEmpty() || bInput.getText().isEmpty() || cInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (checkIfObjectsEmpty()) {
                // Collect inputs
                double a = Integer.parseInt(aInput.getText());
                double b = Integer.parseInt(bInput.getText());
                double c = Integer.parseInt(cInput.getText());

                double z = Math.pow(b, 2) - (4 * a * c);

                // Check if z < 0
                if (z < 0) {
                    // Print message
                    JOptionPane.showMessageDialog(null, "Roots are imaginary", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                // Otherwise check if z = 0
                else if (z == 0) {
                    // Calculate x1 and x2
                    double x1 = -b / (2 * a);

                    // Create output
                    String output = "x1 = " + x1 + "\nx2 = " + x1;
                    // Print output
                    JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                // Else, which means z > 0
                else {
                    // Calculate x1 and x2
                    double x1 = (-b + Math.sqrt(z)) / (2 * a);
                    double x2 = (-b - Math.sqrt(z)) / (2 * a);

                    // Create output
                    String output = "x1 = " + x1 + "\nx2 = " + x2;
                    // Print output
                    JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            resetObjects();
        }
    }
}

public class Quad {
    public static void main(String[] args) {
        new QuadForm();
    }
}

