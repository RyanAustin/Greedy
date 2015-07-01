import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Ryan
 * Date: 6/18/14
 * Time: 3:05 AM
 */
public class Greedy {


    public static void main(String[] varArgs) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        CoinCalculator obj = (CoinCalculator) context.getBean("calculator");
        System.out.println(obj.inputReader());

    }

}
