package appiumtests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class AlaramTest {
    public static void alaramTest() throws Exception{
            UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("OPPO A57");
        options.setUdid("IRBIGI7DWWCEPVWS");
        options.setPlatformName("Android");
        options.setPlatformVersion("14");

        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.coloros.alarmclock");
        options.setAppActivity("com.coloros.alarmclock.AlarmClock");
        options.setIgnoreHiddenApiPolicyError(true);
        options.setNoReset(true);
        options.setFullReset(false);

        URL url = new URL("http://127.0.0.1:4723");

        AppiumDriver driver = new AndroidDriver(url, options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
//
         // set alarm
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.coloros.alarmclock:id/coui_floating_button_main_fab\")"
                )
        )).click();

        // save alrm
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                                "new UiSelector().resourceId(\"com.coloros.alarmclock:id/save\")"
                            )
        )).click();

        // click timer
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.coloros.alarmclock:id/navigation_bar_item_icon_view\").instance(3)"
                )
        )).click();

    // Timer start
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.coloros.alarmclock:id/coui_floating_button_main_fab\")"
                )
        )).click();

        // Take 2 second timer
    Thread.sleep(2000);

    // Stop Timer
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.coloros.alarmclock:id/first_component\")"
                )
        )).click();



        // world clock
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.coloros.alarmclock:id/fl_root\").instance(1)"
                )
        )).click();

        // view Digital-clock
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.coloros.alarmclock:id/click_view\")"
                )
        )).click();

      //  click stop watch bar

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.coloros.alarmclock:id/fl_root\").instance(2)"
                )
        )).click();
        driver.quit();

    System.out.println("Succes without error");
    }


//    public static void alarmTest
}

