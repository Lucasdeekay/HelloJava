import javax.swing.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

// This program prints something on the console
public class App {
    public static void main(String[] args) {
        calculateL();
    }

    // Method collects numeric input
    public static float getNumericInput(String prompt) {
        do {
            try {
                return Float.parseFloat(JOptionPane.showInputDialog(prompt));
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }

    static void calculateL(){
        double p = getNumericInput("Enter Value For P");
        double k = getNumericInput("Enter Value For K");
        double r = getNumericInput("Enter Value For R");

        double l = p*k*r;
        JOptionPane.showMessageDialog(null, "P*K*R = " + l, " Solution", JOptionPane.INFORMATION_MESSAGE);
    }

    static void calculateR(){
        double r = getNumericInput("Enter Value For R");
        double p = getNumericInput("Enter Value For P");
        double l = getNumericInput("Enter Value For L");
        double b = getNumericInput("Enter Value For B");

        r = ( (14 * (r / p)) * (5 * (l * b)) );
        JOptionPane.showMessageDialog(null, "(14 * (R / P)) * (5 * (L * B)) = " + r, " Solution", JOptionPane.INFORMATION_MESSAGE);
    }
}

