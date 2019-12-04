package com.selenium.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FuxiSelenium {
    WebDriver driver;
    public void InitDriver(){
        //System.setProperty("webdriver.chrome.driver","E:\\webdriver\\chromedriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("http://www.imooc.com");
        driver.manage().window().maximize();
    }
    public void GetElement(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("js-signin-btn")).click();
        driver.findElement(By.name("email")).sendKeys("17186873856");
        driver.findElement(By.className("js-loginPassword")).sendKeys("Summer123");
        WebElement NodeElement = driver.findElement(By.className("rlf-autoin"));
        NodeElement.findElement(By.tagName("input"));
        List<WebElement> ButtonElement = driver.findElements(By.className("rlf-group"));
        ButtonElement.get(4).click();
        //driver.findElements(By.linkText("找回密码")).click();
        //driver.findElements(By.partialLinkText("无法")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
    public static void main(String[] args){
        FuxiSelenium fuxiSelenium = new FuxiSelenium();
        fuxiSelenium.InitDriver();

        fuxiSelenium.GetElement();

    }
}

