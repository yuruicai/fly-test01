package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class localTest1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver.get("http://www.baidu.com");
        Thread.sleep(1000);
        //driver.findElement(By.id("kw")).sendKeys("selenium");
        //driver.findElement(By.name("wd")).sendKeys("webdriver");
        //driver.findElement(By.className("s_ipt")).sendKeys("iedriver");
        //根据链接定位
        //driver.findElement(By.linkText("新闻")).click();
        //根据部分链接定位
        driver.findElement(By.partialLinkText("新")).click();
    }
}
