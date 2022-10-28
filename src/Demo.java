import java.text.NumberFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        stallBill();
    }

    public static double getPrincipal(){
        Scanner user = new Scanner(System.in);
        System.out.print("Principal: ");
        return user.nextDouble();
    }
    public static double getRate(){
        Scanner user = new Scanner(System.in);
        System.out.print("Rate: ");
        return user.nextDouble();
    }
    public static int getPeriod(){
        Scanner user = new Scanner(System.in);
        System.out.print("Period: ");
        return user.nextInt();
    }
    public static void calculateMortgage(){
        final int MONTHS_IN_YEAR = 12;
        double principal = getPrincipal();
        double rate = getRate()/ (100 * MONTHS_IN_YEAR);
        int period = getPeriod();

        double pow = Math.pow(1 + rate, period * MONTHS_IN_YEAR);
        double mortgage = principal * ( (rate * pow) / (pow - 1) );
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
    public static void fizzBuzz(int number){
        if (number % 3 == 0 && number % 5 == 0){
            System.out.println("FizzBuzz");
        }
        else if (number % 5 == 0){
            System.out.println("Buzz");
        }
        else if (number % 3 == 0){
            System.out.println("Fizz");
        }
        else
            System.out.println(number);
    }

    static double returnDiscount(int quantity, int PRICE){
        double discount;
        if (quantity <= 5){
            discount = 0.02 * PRICE;
        }
        else if (quantity <= 10){
            discount = 0.04 * PRICE;
        }
        else{
            discount = 0.1 * PRICE;
        }
        return discount;
    }

    static int getInput(){
        Scanner user = new Scanner(System.in);
        int quantity = 0;
        try {
            System.out.print("Quantity: ");
            quantity = user.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Input a number");
        }
        return quantity;
    }
    public static void stallBill(){
        int PRICE = 30_000;
        int quantity;
        do {
            quantity = getInput();
        } while (quantity <= 0);
        double discount = returnDiscount(quantity, PRICE);
        double grossPay = PRICE * quantity;
        double netPay = grossPay - discount;
        String message =
                "Price: " + NumberFormat.getCurrencyInstance().format(PRICE) + "\n" +
                "Quantity: " + NumberFormat.getCurrencyInstance().format(quantity) + "\n" +
                "Gross Pay: " + NumberFormat.getCurrencyInstance().format(grossPay) + "\n" +
                "Discount: " + NumberFormat.getCurrencyInstance().format(discount) + "\n" +
                "Net Pay: " + NumberFormat.getCurrencyInstance().format(netPay) + "\n";
        System.out.println(message);

    }
}

