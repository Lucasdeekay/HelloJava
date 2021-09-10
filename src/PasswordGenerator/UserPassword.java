package PasswordGenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPassword {
    public static void main(String[] args) {
        changePassword();
    }

    // Method prompts user to choose if they ant to change password
    static int getUserChoice(){
        Scanner user = new Scanner(System.in);

        boolean loop = true;
        int confirmPassword = 0;

        do {
            try {
                System.out.print("\nEnter\n1 -> Yes\n2 -> No\nDo yu want to change your password? ");
                confirmPassword = user.nextInt();
                loop = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong Input");
            }
        }while (loop);

        return confirmPassword;
    }

    // Method prints out the new password
    static String confirmUserChoice(String passwordString){
        Scanner user = new Scanner(System.in);

        do {
            int userChoice = getUserChoice();
            if (userChoice == 1) {
                System.out.print("\nEnter Password: ");
                passwordString = user.next();
                System.out.println("Password successfully changed");
                break;
            } else if (userChoice == 2) {
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        }while (true);

        return passwordString;
    }

    public static void changePassword(){

        String passwordString = GeneratePassword.getPassword();

        passwordString = confirmUserChoice(passwordString);

        System.out.println("\nPassword: " + passwordString);

    }
}
