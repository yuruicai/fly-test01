package com.selenium.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class seleniumTestDemo2 {
    public static void main(String[] args){
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.get("https://www.imooc.com/");
        driver.findElement(By.id("js-signin-btn")).click();
        driver.findElement(By.className("xa-emailOrPhone")).sendKeys("17816873856");
        driver.findElement(By.name("password")).sendKeys("Summer123");
        driver.findElement(By.id("auto-signin")).click();

        //driver.findElement(By.className("active-title")).click();
        //driver.findElement(By.className("xa-showSignup")).click();

        //driver.findElement(By.name("password")).sendKeys("Summer123");
        driver.findElement(By.className("moco-btn-red")).click();
        driver.manage().window().maximize();

        /**
        driver.get("https://www.imooc.com/");
        driver.findElement(By.className("search-input")).click();
        driver.findElement(By.className("search-input")).sendKeys("java");
        WebElement element = driver.findElement(By.className("nav-item"));
        WebElement elements = (WebElement) element.findElements(By.tagName("li"));
        elements.click();
         **/
    }
}
