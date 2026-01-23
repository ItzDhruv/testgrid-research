package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main extends LoginTest {

    public static void main(String[] args) {

        LoginTest loginTest = new LoginTest();
        loginTest.valid_login_test();
        loginTest.invalid_login_test();



        YoutubeTest youtubeTest = new YoutubeTest();
        youtubeTest.youtube_test();


    }
}
