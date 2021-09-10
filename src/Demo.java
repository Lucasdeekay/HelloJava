import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int randomNumber = (int) Math.ceil(Math.random() * 100);
        System.out.println(randomNumber);
        fizzBuzz(randomNumber);
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

        double mortgage = principal * ( (rate * Math.pow(1 + rate, period*MONTHS_IN_YEAR)) / (Math.pow((1 + rate), period*MONTHS_IN_YEAR) - 1) );
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
}

