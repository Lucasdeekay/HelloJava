import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

// This program prints something on the console
public class App {
    public static void main(String[] args) {
        float sum = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            System.out.print("Enter Number " + (i+1) + ": ");
            float num = input.nextFloat();
            sum += num;
        }
        System.out.println("Average: " + sum/3);
    }
}
