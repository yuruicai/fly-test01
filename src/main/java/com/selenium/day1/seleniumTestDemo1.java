package com.selenium.day1;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumTestDemo1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        System.out.println("hello!");
    }
}
