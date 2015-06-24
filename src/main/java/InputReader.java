import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * User: Ryan
 * Date: 6/24/2015
 * Time: 3:26 PM
 */
public class InputReader {

    public Double read(){
        boolean inputCheck = false;
        double amount = 0;

        while (inputCheck == false || amount < 0) {
            if (amount < 0){
                System.out.println("Please enter a positive amount.");
                amount = 0;
            }

            try {
                System.out.print("Enter the amount: $");
                amount = new Scanner(System.in).nextDouble();
                inputCheck = true;
            } catch (InputMismatchException exception) {
                System.out.println("Not an integer.");
                inputCheck = false;
            }
        }

        return amount;
    }
}
