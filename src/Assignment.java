import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {

    }

    // This method collects numerical input from the user
    public static double getNumberInput(String prompt){
        // Creating Scanner object
        Scanner input = new Scanner(System.in);
        /*
        Using try-catch block to catch Exceptions
        Wrapping a do-while loop around it as well so that it would
        prompt the user again if the correct type of input was not
        entered
         */
        do{
            try{
                System.out.print(prompt);
                return input.nextDouble();
            }catch (Exception e){
                System.out.println("Invalid input. Input must be a number");
            }
        }while (true);
    }

    // This method computes the area of a rectangle
    public static void AreaOfRectangle(){
        System.out.println("This program computes the area of a rectangle\n");
        // Collecting user inputs
        double length = getNumberInput("Enter Length: ");
        double breadth = getNumberInput("Enter Breadth: ");
        // Outputting the results
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Area: " + (length * breadth));
    }

    // This method computes he area of a triangle
    public static void AreaOfTriangle(){
        System.out.println("This program computes the area of a triangle\n");
        // Collecting user inputs
        double base = getNumberInput("Enter Base: ");
        double height = getNumberInput("Enter Height: ");
        // Outputting the results
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
        System.out.println("Area: " + (0.5 * base * height));
    }

    // This method returns the area and circumference of a circle
    public static void CircleAreaAndCircumference(){
        System.out.println("This program computes the area and circumference of a circle\n");
        // Collecting user inputs
        double radius = getNumberInput("Enter Radius: ");
        // Outputting the results
        System.out.println("Radius: " + radius);
        System.out.println("Circumferece: " + (2 * Math.PI * radius));
        System.out.println("Area: " + (Math.PI  * Math.pow(radius, 2)));
    }
}
