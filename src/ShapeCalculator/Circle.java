package ShapeCalculator;

public class Circle {
    public static void main(String[] args) {

    }

    public static double area(double radius){
        return Math.PI  * Math.pow(radius, 2);
    }

    public static double circumference(double radius){
        return 2 * Math.PI  * radius;
    }
}
