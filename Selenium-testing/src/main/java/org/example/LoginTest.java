package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {


    public static void valid_login_test(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:3000");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("loginBtn")).click();

        String result = driver.findElement(By.id("message")).getText();
        System.out.println("Valid test : "+result);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invalid_login_test(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:3000");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("134");
        driver.findElement(By.id("loginBtn")).click();

        String result = driver.findElement(By.id("message")).getText();
        System.out.println("Invalid test : "+result);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
