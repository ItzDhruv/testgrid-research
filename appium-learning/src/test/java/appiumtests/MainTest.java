package appiumtests;

import static appiumtests.CalculatorTest.openCalculator;
import static appiumtests.AlaramTest.alaramTest;

public class MainTest {
    public static void main(String[] args) {
        try {
            openCalculator();
//            Thread.sleep(4000);
//            alaramTest();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
