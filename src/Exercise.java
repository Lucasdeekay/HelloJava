// import package
import java.util.*;

public class Exercise{
    public static void main(String[] args){
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Print message to collect full name
        System.out.println("Enter full name");
        // Collect input using next()
        // next() only collects the first word input by the user
        // String fullName = input.next();

        // I have commented out that code on line 13, so it is not ging to work
        // Collect input using nextLine()
        // nextLine() collects a line of input or the whole sentence entered
        String fullName = input.nextLine();

        // Print out the full name
        System.out.println(fullName);
    }
}