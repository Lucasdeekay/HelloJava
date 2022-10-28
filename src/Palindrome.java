import javax.swing.*;

public class Palindrome {
    public static void main(String[] args) {
        String userInput = "";
        try {
            userInput = JOptionPane.showInputDialog("Enter To Check If Palidrome");
            int number = Integer.parseInt(userInput);
            palindrome(number);
        }
        catch (Exception e) {
            palindrome(userInput.toUpperCase());
        }
    }

    // Method reverses a number
    public static int reverseNumber(int number){
        int reversedNumber = 0;
        // Loop for the number of times equal to the length of the number
        for (int i = String.valueOf(number).length(); i > 0 ; i--){
            int remainder = number % 10; // Get the remainder of the number after dividing by 10
            number = (number - remainder) / 10;
            reversedNumber = (reversedNumber * 10) + remainder;
        }
        return reversedNumber;
    }

    // Method checks if a number is palindrome
    public static void palindrome(int number){
        int reversedNumber = reverseNumber(number);
        if (number == reversedNumber){
            JOptionPane.showMessageDialog(null, "True", number + " is palindrome?", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "False", number + " is palindrome?", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method checks if a string is palindrome
    public static void palindrome(String userInput){
        String reverseInput = "";
        for (int i = userInput.length() - 1; i >= 0; i--) {
            reverseInput = reverseInput + userInput.charAt(i);
        }
        if (reverseInput.equals(userInput)) {
            JOptionPane.showMessageDialog(null, "True", userInput + " is palindrome?", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "False", userInput + " is palindrome?", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
