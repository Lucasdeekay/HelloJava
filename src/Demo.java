// This program solves the quadratic equation for given
// values a, b, and c

// Import package
import java.text.NumberFormat;
import java.util.*;


public class Demo {
    public static void main(String[] args){

    }

    public static void quadEquation(){
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Print message to collect input for a
        System.out.print("Enter a: ");
        // Collect input for a
        int a = input.nextInt();

        // Print message to collect input for b
        System.out.print("Enter b: ");
        // Collect input for b
        int b = input.nextInt();

        // Print message to collect input for c
        System.out.print("Enter c: ");
        // Collect input for c
        int c = input.nextInt();

        // Caluclate z
        double z = Math.pow(b, 2) - (4 * a * c);

        // Check if z < 0
        if (z < 0){
            // Print message
            System.out.println("Roots are imaginary");
        }
        // Otherwise check if z = 0
        else if (z == 0) {
            // Calculate x1 and x2
            double x1 = -b / (2 * a);
            double x2 = -b / (2 * a);

            // Create output
            String output = "x1 = " + x1 + "\nx2 = " + x2;
            // Print output
            System.out.println(output);
        }
        // Else, which means z > 0
        else {
            // Calculate x1 and x2
            double x1 = (-b + Math.sqrt(z)) / (2 * a);
            double x2 = (-b - Math.sqrt(z)) / (2 * a);

            // Create output
            String output = "x1 = " + x1 + "\nx2 = " + x2;
            // Print output
            System.out.println(output);
        }
    }

    public static void celsiusToFahrenheit(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for celsius: ");
        double celsius = input.nextDouble();

        double fahrenheit = celsius * 33.8;

        System.out.println("Celsius: " + celsius + "\nFahrenheit: " + fahrenheit);
    }

    public static void simpleInterest(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for Principal ($): ");
        double principal = input.nextDouble();

        System.out.print("Enter value for Rate (%): ");
        double rate = input.nextDouble();

        System.out.print("Enter value for Time (Yrs): ");
        double time = input.nextDouble();

        double interest = principal * (rate/100) * time;

        System.out.println("Simple Interest: " + NumberFormat.getCurrencyInstance().format(interest));
    }
}