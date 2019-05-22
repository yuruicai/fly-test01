package com.selenium.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

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

        driver.findElement(By.id("js-signin-btn")).click();
        //user.sendKeys("17816873856");

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
        driver.findElement(By.name("password")).sendKeys("Summer123");
        driver.findElement(By.className("moco-btn-red")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单选框
     * */
    public void rediobox(){
        driver.get("https://www.imooc.com/user/setprofile");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("pull-right")).click();
        WebElement sex_node = driver.findElement(By.className("moco-control-input"));
        List<WebElement> list_sex = sex_node.findElements(By.tagName("input"));
        for(WebElement sex:list_sex){
            boolean flag = sex.isSelected();
            if(flag == true){
                continue;
            }else {
                sex.click();
                break;
            }
        }
    }

    public static void main(String[] args){
        ActionSelenium action = new ActionSelenium();
        action.InitDriver();
        action.InputBox();
        action.rediobox();
    }
}
