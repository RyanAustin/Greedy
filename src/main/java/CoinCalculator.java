import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:06 AM
 */
public class CoinCalculator {

    public CoinCalculator (InputReader input) {
        System.out.print(calculateChange(input.read()));
    }

    private String calculateChange(double amount) {
        int change = 0;

        if (amount == 0) {
            return "No coins returned";
        } else {
            while (amount >= 1) {
                change++;
                amount -= 1.00;
            }
            while (amount >= .50) {
                change++;
                amount -= .50;
            }
            while (amount >= .25) {
                change++;
                amount -= .25;
            }
            while (amount >= .10) {
                change++;
                amount -= .10;
            }
            while (amount >= .05) {
                change++;
                amount -= .05;
            }
            while (amount >= .01) {
                change++;
                amount -= .01;
            }
            return coinsNeeded(change);
        }
    }

    private String coinsNeeded(int change) {
        if (change > 1 || change == 0) {
            return change + " " + "coins";
        } else {
            return change + " " + "coin";
        }
    }
}
