package com.selenium.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FuxiSelenium2 {
    public WebDriver driver;
    public void InitDriver(){
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

        driver = new FirefoxDriver();
        driver.get("http://www.imooc.com");
    }
    public void InputElement(){
        WebElement SearchElement = driver.findElement(By.className("search-input"));

        SearchElement.sendKeys("自动化");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //SearchElement.clear();
        String SearchInfo = SearchElement.getAttribute("placeholder");
        System.out.println(SearchInfo);
        String wenzi = SearchElement.getAttribute("value");
        System.out.println(wenzi);
        boolean info = SearchElement.isEnabled();
        System.out.println(info);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    public static void main(String args[]){
        FuxiSelenium2 fuxiSelenium2 = new FuxiSelenium2();
        fuxiSelenium2.InitDriver();
        fuxiSelenium2.InputElement();
    }
}
