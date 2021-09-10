package BasicCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        printInstruction();
        performCalculations();
    }

    // Method prints necessary instruction
    public static void printInstruction(){
        String message = "Input the following to perform calculations\n" +
                "+ -> Addition\n" +
                "- -> Subtraction\n" +
                "* -> Multiplication\n" +
                "/ -> Divide\n" +
                "^ -> Power\n" +
                "= -> Get result\n";
        System.out.println(message);
    }

    // Method gets user input
    public static double getNumber(){
        double number = 0;
        boolean loop = true;

        do{
            try{
                Scanner user = new Scanner(System.in);

                System.out.print("Enter Number: ");
                number = user.nextDouble();

                loop = false;
            }
            catch (NumberFormatException | InputMismatchException e){
                System.out.println("Invalid Input");
            }
        }while (loop);

        return number;
    }

    // Method gets user input
    public static String getOperator(){
        String symbol = "";
        boolean loop = true;

        do{
            try{
                Scanner user = new Scanner(System.in);

                System.out.print("Enter Operator: ");
                symbol = user.next();

                loop = false;
            }
            catch (NumberFormatException | InputMismatchException e){
                System.out.println(e);
            }
        }while (loop);

        return symbol;
    }

    // Method does arithmetic calculation
    public static void performCalculations(){
        double total = getNumber();

        String operator;

        do {

            operator = getOperator();
            switch (operator){

                case "+"-> {
                    double nextNumber = getNumber();
                    total = MathsOperations.add(total, nextNumber);
                }

                case "-"-> {
                    double nextNumber = getNumber();
                    total = MathsOperations.subtract(total, nextNumber);
                }

                case "*"-> {
                    double nextNumber = getNumber();
                    total = MathsOperations.multiply(total, nextNumber);
                }

                case "/"-> {
                    double nextNumber = getNumber();
                    total = MathsOperations.divide(total, nextNumber);
                }

                case "^"-> {
                    double nextNumber = getNumber();
                    total = MathsOperations.power(total, nextNumber);
                }

                case "="-> {
                    String result = "Answer: " + total;
                    System.out.println(result);
                }

                default -> System.out.println("Invalid Operator");
            }

        }while (!operator.equalsIgnoreCase("="));

    }
}
