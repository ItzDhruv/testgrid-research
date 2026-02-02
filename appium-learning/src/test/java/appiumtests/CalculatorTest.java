package appiumtests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.net.URL;

public class CalculatorTest {

    static AndroidDriver driver;


    public static void openCalculator() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("OPPO A57");
        options.setUdid("IRBIGI7DWWCEPVWS");
        options.setPlatformName("Android");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.setIgnoreHiddenApiPolicyError(true);
        options.setNoReset(true);
        options.setFullReset(false);


        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, options);
        driver.findElement(By.id("com.coloros.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.coloros.calculator:id/img_op_mul")).click();
        driver.findElement(By.id("com.coloros.calculator:id/digit_8")).click();
        driver.findElement(By.id("com.coloros.calculator:id/eq")).click();
        driver.findElement(By.id("com.coloros.calculator:id/clr")).click();

        System.out.println("Calculator app started ");
            try{
                Thread.sleep(5000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        driver.quit();
        System.out.println("Driver close");
    }
}