package appiumtests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

class DialerTest {

    public static void dialerTest() throws Exception {

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "Genymotion");
//        caps.setCapability("udid", "127.0.0.1:6555");
//
//        // Platform
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "11");
//        caps.setCapability("automationName", "UiAutomator2");
//
//        // Dialer app
//        caps.setCapability("appPackage", "com.android.dialer");
//        caps.setCapability("appActivity",
//                "com.android.dialer.main.impl.MainActivity");
//
//        // Settings
//        caps.setCapability("noReset", true);
//        caps.setCapability("autoGrantPermissions", true);
//
//        // Stability
//        caps.setCapability("newCommandTimeout", 300);
//        caps.setCapability("disableWindowAnimation", true);






        UiAutomator2Options options = new UiAutomator2Options();


        // Emulator details
        options.setDeviceName("Genymotion");
        options.setUdid("127.0.0.1:6555");

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Dialer app
        options.setAppPackage("com.android.dialer");
        options.setAppActivity("com.android.dialer.main.impl.MainActivity");

        options.setNoReset(true);
        options.setAutoGrantPermissions(true);

        // Appium server url
        URL url = new URL("http://127.0.0.1:4723");

        AndroidDriver driver = new AndroidDriver(url, options);



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // With all locator

        // byID             ------------------------------------------------------------------

        try {
            wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("com.android.dialer:id/fab"))
            )
                    .click();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // by access id      ------------------------------------------------------------------

//        try {
//            driver.findElement(AppiumBy.accessibilityId("key pad")).click();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//        // by android amutor        ------------------------------------------------------------------
//
//        try {
//            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.dialer:id/fab\")")).click();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//        //   by x-path             ------------------------------------------------------------------
////
//        try {
//            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"key pad\"]")).click();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//



//        driver.findElement(By.className("\t\n" +
//                "android.widget.LinearLayout")).click();

//        driver.findElement(By.className("android.widget.LinearLayout")).click();

//        try {
//            driver.findElement(AppiumBy.accessibilityId("key pad")).click();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


//        // Open keypad (if needed)
//        driver.findElement(By.id("com.android.dialer:id/fab")).click();
//
//        // Type number
//        driver.findElement(By.id("com.android.dialer:id/digits"))
//                .sendKeys("9876543210");
//
//        // Click call
//        driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button"))
//                .click();
//
//        Thread.sleep(5000);
//
//        // End call
//        driver.findElement(By.id("com.android.dialer:id/incall_end_call"))
//                .click();

        driver.quit();
    }
}
