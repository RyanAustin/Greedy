import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:06 AM
 */
public class CoinCalculator {

    private CoinSet coins;
    double amount = 0;

    public String calculateChange(String str) {
        if (checkForCurrency(str)) {
            this.amount = Double.parseDouble(str.substring(1));
        } else {
            this.amount = Double.parseDouble(str);
        }

        return calculateChange();
    }

    private String calculateChange() {
        if (this.amount == 0) {
            return "No coins returned";
        } else {
            Coin[] coinSet = coins.getCoins();
            int numberOfCoins = 0;
            int coinPosition = 0;
            while (this.amount >= 0.01) {
                numberOfCoins += this.amount / coinSet[coinPosition].getValue();
                this.amount %= coinSet[coinPosition].getValue();
                coinPosition++;
            }

            return coinsNeeded(numberOfCoins);
        }
    }

    private void setCurrency(String currency) {
        char euro = 128;

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        this.coins = (CoinSet) context.getBean("USCoinSet");

        if (currency.equals(String.valueOf(euro))) {
            this.coins = (CoinSet) context.getBean("EUCoinSet");
        }
    }

    private boolean checkForCurrency(String input) {
        String currency = input.substring(0,1);
        setCurrency(currency);

        if (currency.equals("$") || currency.equals("€")) {
            return true;
        }
        return false;
    }

    private String coinsNeeded(int change) {
        if (change > 1 || change == 0) {
            return change + " " + "coins";
        } else {
            return change + " " + "coin";
        }
    }

    public String inputReader() {
        boolean check = false;
        String str = null;
        System.out.println("Enter the amount:");

        while (!check) {
            try {
                str = new Scanner(System.in).nextLine();
                this.amount = Double.parseDouble(str.substring(checkForCurrency(str) ? 1 : 0));

                if (!str.contains("-")) {
                    check = true;
                } else {
                    System.out.println("Invalid input, please enter a positive number.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input, not an integer.");
                check = false;
            }
        }

        return calculateChange();
    }
}
