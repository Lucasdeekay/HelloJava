package AutomobileCompany;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetData {
    public static void main(String[] args) {
        // Empty on purpose
    }

    // Method returns price of automobile
    static double GetPriceOfAutomobile(String automobile){
        double BICYCLE = 15_000;
        double MOTORBIKE = 128_560;
        double TRICYCLE = 347_950;
        double CAR = 545_600;
        double JEEP = 678_650;
        double TRUCK = 882_245;

        double price = 0;

        switch (automobile){
            case "Bicycle" -> price = BICYCLE;
            case "Motorbike" -> price =  MOTORBIKE;
            case "Tricycle" -> price = TRICYCLE;
            case "Car" -> price = CAR;
            case "Jeep" -> price = JEEP;
            case "Truck" -> price = TRUCK;
        }

        return price;
    }

    // Method returns the current stock of the automobile to be purchased
    static int GetStockOfAutomobile(int[] stockList, String automobile){

        int stock = 0;

        switch (automobile){
            case "Bicycle" -> stock = stockList[0];
            case "Motorbike" -> stock = stockList[1];
            case "Tricycle" -> stock = stockList[2];
            case "Car" -> stock = stockList[3];
            case "Jeep" -> stock = stockList[4];
            case "Truck" -> stock = stockList[5];
        }
        return stock;
    }

    // Method checks if the number of quantity to be bought is available
    static boolean CheckStock(int[] stockList, String automobile, int quantity){
        boolean isAvailable = false;

        int stockAvailable = GetStockOfAutomobile(stockList, automobile);

        if (quantity <= stockAvailable)
            isAvailable = true;

        return isAvailable;
    }

    // Method returns mode of payment
    static String GetModeOfPayment(){

        byte indexOfPaymentMode;

        do{
            String message = "\nENTER\n" +
                    "1 -> Card\n" +
                    "2 -> Cash\n" +
                    "3 -> Installments\n";
            System.out.println(message);

            try {
                Scanner user = new Scanner(System.in);

                System.out.print("Mode Of Payment: ");
                indexOfPaymentMode = user.nextByte();

                if (indexOfPaymentMode >= 1 && indexOfPaymentMode <= 3) {
                    break;
                }
                else {
                    System.out.println("Index not available\n");
                }
            }
            catch (NumberFormatException| InputMismatchException e){
                System.out.println("Input must be a number\n");
            }
        }while (true);

        String paymentMode = "";

        switch (indexOfPaymentMode) {
            case 1 -> paymentMode = "Card";
            case 2 -> paymentMode = "Cash";
            case 3 -> paymentMode = "Installments";
        }

        return paymentMode;
    }

    // Method returns discount rates
    static float GetDiscountRate(int quantity) {
        float rate = 0;
        if (quantity < 5) {
            rate = 0;
        }
        else if (quantity < 10) {
            rate = 0.015F;
        }
        else if (quantity < 20) {
            rate = 0.0185F;
        }
        else if (quantity < 30) {
            rate = 0.02245F;
        }
        else if (quantity < 40) {
            rate = 0.0275F;
        }
        else if (quantity < 50) {
            rate = 0.03F;
        }
        return rate;
    }

    // Method gets user unique 4-digit pin
    static void GetUserPin() {

        do{
            try {
                Scanner user = new Scanner(System.in);

                System.out.print("Pin: ");
                int pin = user.nextInt();

                if (String.valueOf(pin).length() == 4) {
                    System.out.println("Transaction successful\n");
                    break;
                }
                else {
                    System.out.println("Pin must be 4-digit\n");
                }
            }
            catch (InputMismatchException|NumberFormatException e){
                System.out.println("Input must be a number\n");
            }
        }while (true);
    }

    // Method gets duration of installment
    static String GetDurationOfInstallment(){

        byte duration;

        do {
            String message = "\nTO CHOOSE DESIRED DURATION OF PAYMENT, ENTER\n" +
                    "1 -> 3months\n" +
                    "2 -> 6months\n" +
                    "3 -> 12months\n";
            System.out.println(message);

            try{
                Scanner user = new Scanner(System.in);

                System.out.print("Enter Desired Index: ");
                duration = user.nextByte();
                if (duration >= 1 & duration <= 3) {
                    break;
                }
                else {
                    System.out.println("Index not available\n");
                }
            }
            catch (NumberFormatException|InputMismatchException e) {
                System.out.println("Input must be a number\n");
            }
        }while (true);

        String durationInString = "";

        switch (duration) {
            case 1 -> durationInString = "3months";
            case 2 -> durationInString = "6months";
            case 3 -> durationInString = "12months";
        }

        return durationInString;
    }

    // Method returns interest rate
    static float GetInterestRate(String periodOfPayment){
        float interestRate = 0;

        switch (periodOfPayment) {
            case "3months" -> interestRate = 0.0375F;
            case "6months" -> interestRate = 0.05F;
            case "12months" -> interestRate = 0.075F;
        }
        return interestRate;
    }
}
