import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
public class SafeInputObjTest {
    public static void main(String[] args){
    SafeInputObj obj = new SafeInputObj();

    //Testing getNonZeroLenString
        String test = obj.getNonZeroLenString("What is your name? ");
        System.out.println("Your name is: " + test);

        // Test getRangedInt
        int favNum = obj.getRangedInt("What is your favorite number? ", 1, 100);
        System.out.println("Your favorite number is: " + favNum);

        // Test getInt
        int otherNum = obj.getInt("Pick any number ");
        System.out.println("You picked the number: " + otherNum);

        // Test getRangedDouble
        double cost = obj.getRangedDouble("What is the cost of the item?", 0, 1000);
        System.out.println("The cost is: " + cost);

        // Test getDouble
        double total = obj.getDouble("What is the total cost?");
        System.out.println("The total cost is: " + total);

        // Test getYNConfirm
        boolean confirm = obj.getYNConfirm("Are you done? Yes or no ");
        System.out.println("You picked " + confirm);

        // Test getRegExString
        String id = obj.getRegExString("Enter your 5 digit id number ", "^\\d{5}$");
        System.out.println("You entered " + id);

        System.out.println("Tests done!");
    }
}