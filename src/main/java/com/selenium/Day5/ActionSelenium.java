package com.selenium.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActionSelenium {
    public WebDriver driver = null;
    /**
     * 初始化driver
     * **/
    public void InitDriver(){
        driver = new FirefoxDriver();
        driver.get("https://www.imooc.com/");
    }
    /**
     * 输入框
     * **/
    public void InputBox(){

        WebElement login = driver.findElement(By.id("js-signin-btn"));
        //user.sendKeys("17816873856");
        login.click();

        WebElement user = driver.findElement(By.name("email"));
        user.sendKeys("17816873855");
        user.clear();
        user.sendKeys("17816873856");
        String user_info = user.getAttribute("placeholder");
        System.out.println(user_info);
        String user_value = user.getAttribute("value");
        System.out.println(user_value);
        boolean enable = user.isEnabled();
        System.out.println(enable);
    }
    public static void main(String[] args){
        ActionSelenium action = new ActionSelenium();
        action.InitDriver();
        action.InputBox();

    }
}
