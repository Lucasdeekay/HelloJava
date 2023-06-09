package ShapeCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Choose Shape You Want To Calculate\n1 - Circle\n2 - Square\n3 - Rectangle\n4 - Triangle\n5 - Parallelogram\nEnter Choice: ");
        int userShape = input.nextInt();

        switch (userShape) {
            case 1:
                int userChoice = areaOrPerimeter();
                switch (userChoice) {
                    case 1:
                        System.out.print("Enter radius: ");
                        double radius = input.nextDouble();
                        System.out.println("Area: " + Circle.area(radius));
                    case 2:
                        System.out.print("Enter radius: ");
                        radius = input.nextDouble();
                        System.out.println("Perimeter: " + Circle.circumference(radius));
                    default:
                        System.out.println("Invalid Input");
                }
            case 2:
                userChoice = areaOrPerimeter();
                switch (userChoice) {
                    case 1:
                        System.out.print("Enter length: ");
                        double length = input.nextDouble();
                        System.out.println("Area: " + Square.area(length));
                    case 2:
                        System.out.print("Enter length: ");
                        length = input.nextDouble();
                        System.out.println("Perimeter: " + Square.perimeter(length));
                    default:
                        System.out.println("Invalid Input");
                }
            case 3:
                userChoice = areaOrPerimeter();
                switch (userChoice) {
                    case 1:
                        System.out.print("Enter length: ");
                        double length = input.nextDouble();
                        System.out.print("Enter breadth: ");
                        double breadth = input.nextDouble();
                        System.out.println("Area: " + Rectangle.area(length, breadth));
                    case 2:
                        System.out.print("Enter length: ");
                        length = input.nextDouble();
                        System.out.print("Enter breadth: ");
                        breadth = input.nextDouble();
                        System.out.println("Perimeter: " + Rectangle.perimeter(length, breadth));
                    default:
                        System.out.println("Invalid Input");
                }
            case 4:
                userChoice = areaOrPerimeter();
                switch (userChoice) {
                    case 1:
                        System.out.print("Enter base: ");
                        double base = input.nextDouble();
                        System.out.print("Enter height: ");
                        double height = input.nextDouble();
                        System.out.println("Area: " + Triangle.area(base, height));
                    case 2:
                        System.out.print("Enter base: ");
                        base = input.nextDouble();
                        System.out.print("Enter side 1: ");
                        double side1 = input.nextDouble();
                        System.out.print("Enter side 2: ");
                        double side2 = input.nextDouble();
                        System.out.println("Perimeter: " + Triangle.perimeter(base, side1, side2));
                    default:
                        System.out.println("Invalid Input");
                }
            case 5:
                userChoice = areaOrPerimeter();
                switch (userChoice) {
                    case 1:
                        System.out.print("Enter base: ");
                        double base = input.nextDouble();
                        System.out.print("Enter height: ");
                        double height = input.nextDouble();
                        System.out.println("Area: " +Parallelogram.area(base, height));
                    case 2:
                        System.out.print("Enter base: ");
                        base = input.nextDouble();
                        System.out.print("Enter side: ");
                        double side = input.nextDouble();
                        System.out.println("Perimeter: " + Parallelogram.perimeter(base, side));
                    default:
                        System.out.println("Invalid Input");
                }
            default:
                System.out.println("Invalid Input");
            }
    }

    public static int areaOrPerimeter () {
        Scanner in = new Scanner(System.in);
        System.out.print("What would you like to calculate\n1- Area\n2- Perimeter\nEnter Choice: ");
        return in.nextInt();
    }
}
