    package org.example;

    import io.appium.java_client.AppiumBy;
    import io.appium.java_client.android.AndroidDriver;
    import io.appium.java_client.android.options.UiAutomator2Options;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.net.ConnectException;
    import java.net.URL;
    import java.time.Duration;


    public class CLearChromeCacheTest {
       public static AndroidDriver driver;
        public static void chrome_clear_cache() throws Exception {

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("OPPO A57");
            options.setUdid("192.168.31.93:42829");
            options.setPlatformName("Android");
            options.setPlatformVersion("14");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.android.settings");
    //        options.setAppActivity("com.android.calculator2.Calculator");
            options.setIgnoreHiddenApiPolicyError(true);
            options.setNoReset(true);
            options.setFullReset(false);

            URL url = new URL("http://127.0.0.1:4723");

            driver = new AndroidDriver(url, options);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

            By connectionSharing = AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"Apps\"))"
            );

            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(connectionSharing)
            );

            element.click();

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator("new UiSelector().text(\"App management\")")
                    )
            ).click();


            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                                    ".scrollIntoView(new UiSelector().text(\"Chrome\"))")
                    )
            ).click();

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().className(\"android.widget.RelativeLayout\").instance(4)\n"
                            )
                    )
            ).click();

            Thread.sleep(2000); // small delay


            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator("new UiSelector().text(\"Clear cache\")")
                    )
            ).click();

    driver.quit();

        }
    }
