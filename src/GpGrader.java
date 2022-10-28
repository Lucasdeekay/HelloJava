import javax.swing.*;

public class GpGrader {
    public static void main(String[] args) {
        float userInput = getNumericInput("Enter GP: ");
        gpGrader(userInput);
    }

    // Method collects numeric input
    public static float getNumericInput(String prompt) {
        do {
            try {
                float number = Float.parseFloat(JOptionPane.showInputDialog(prompt));
                if (number >= 0 && number <= 5){
                    return number;
                }
                else {
                    JOptionPane.showMessageDialog(null, "GP must be between 0 and 5", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }

    // Method returns the grading rank of a gp
    public static void gpGrader(float gp){
        if (gp >= 4.5 && gp <= 5){
            JOptionPane.showMessageDialog(null, "First Class", " GP Grader", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (gp >= 3.5){
            JOptionPane.showMessageDialog(null, "Second Class Upper", " GP Grader", JOptionPane.INFORMATION_MESSAGE);;
        }
        else if (gp >= 2.5){
            JOptionPane.showMessageDialog(null, "Second Class Lower", " GP Grader", JOptionPane.INFORMATION_MESSAGE);;
        }
        else if (gp >= 1.5){
            JOptionPane.showMessageDialog(null, "Third Class", " GP Grader", JOptionPane.INFORMATION_MESSAGE);;
        }
        else if (gp >= 1.0){
            JOptionPane.showMessageDialog(null, "Pass", " GP Grader", JOptionPane.INFORMATION_MESSAGE);;
        }
        else {
            JOptionPane.showMessageDialog(null, "Advice To Withdraw", " GP Grader", JOptionPane.INFORMATION_MESSAGE);;
        }
    }
}
