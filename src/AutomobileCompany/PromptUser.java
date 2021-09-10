package AutomobileCompany;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PromptUser {
    public static void main(String[] args) {
        // Empty on purpose
    }

    // Method contacts help/support for info
    static String ContactHelp(){
        String message = "\nContact our support through the following media\n" +
                "E-mail: myautomobilecompany@mail.com\n" +
                "Telephone: +877479763";

        System.out.println(message);

        return "Exit";
    }

    // Method returns string of automobile chosen
    static String Automobiles(){

        byte indexOfAutomobile;

        do {
            try {
                Scanner user = new Scanner(System.in);

                System.out.print("Enter Index Of Automobile -> ");
                indexOfAutomobile = user.nextByte();

                if (indexOfAutomobile >= 0 & indexOfAutomobile <= 7){
                    break;
                }
                else {
                    System.out.println("Index not available\n");
                }
            }
            catch (InputMismatchException |NumberFormatException e) {
                System.out.println("Input must be a number\n");
            }
        }while (true);


        String automobile = "";

        switch (indexOfAutomobile) {
            case 1 -> automobile = "Bicycle";
            case 2 -> automobile = "Motorbike";
            case 3 -> automobile = "Tricycle";
            case 4 -> automobile = "Car";
            case 5 -> automobile = "Jeep";
            case 6 -> automobile = "Truck";
            case 7 -> automobile = ContactHelp();
            case 0 -> automobile = "Exit";
        }

        return automobile;
    }

    // Method gets the quantity of commodity to be purchased
    static int GetQuantityOfAutomobile(){

        int quantity;

        do{
            try{
                Scanner user = new Scanner(System.in);

                System.out.print("Quantity -> ");
                quantity = user.nextInt();
                break;
            }
            catch (NumberFormatException|InputMismatchException e){
                System.out.println("Input must be a number\n");
            }
        }while (true);

        return quantity;
    }
}
