package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeTest extends Thread{
    public void youtube_test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://youtube.com");
        driver.findElement(By.name("search_query")).sendKeys("Java tutorials" + Keys.ENTER);

    try{
      sleep(8000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
        driver.quit();
    }
}
