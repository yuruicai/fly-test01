package com.selenium.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("js-signin-btn")).click();
    }
    /**
     * 输入框
     * **/
    public void InputBox(){

        //user.sendKeys("17816873856");

        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement user = driver.findElement(By.name("email"));
        user.sendKeys("17816873855");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.clear();
        user.sendKeys("17816873856");
        String user_info = user.getAttribute("placeholder");
        System.out.println(user_info);
        String user_value = user.getAttribute("value");
        System.out.println(user_value);
        boolean enable = user.isEnabled();
        System.out.println(enable);
        driver.findElement(By.name("password")).sendKeys("Summer123");
        //driver.findElement(By.className("moco-btn-red")).click();
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
        WebElement sex_node = driver.findElement(By.className("rlf-group"));
        //List<WebElement> list_sex = sex_node.findElements(By.tagName("input"));
        List<WebElement> list_sex=driver.findElements(By.xpath(".//*[@id='profile']/div[4]/div/label/input"));
        for(WebElement sex:list_sex){
            boolean flag = sex.isSelected();
            if(flag == false){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sex.click();
                break;
            }else {
                continue;
            }
        }
    }
    /**
     * 多选框
     * */
    public void checkBox(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            WebElement check = driver.findElement(By.className("rlf-autoin"));
            System.out.println("是否选中了？"+check.isSelected());
            System.out.println("是否有效？"+check.isEnabled());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        check.click();
    }

    /**
     * 按钮
     * */
    public void button(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement login_button = driver.findElement(By.className("moco-btn-red"));

        /**
        //js脚本隐藏按钮
        String jscript = "document.getElementsByClassName('moco-btn-red')[0].style.display='none'";

        //执行js脚本
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jscript);

        boolean is_display = login_button.isDisplayed();
        System.out.println(is_display);
        /**
        boolean is_enable = login_button.isEnabled();
        System.out.println(is_enable);
         */


        login_button.click();
    }
    /**
     * form表单提交
     * */
    public void web_from(){
        driver.get("https://www.imooc.com/");
        driver.findElement(By.id("signup-form")).submit();
    }

    /**
     * 上传文件
     * */
    public void upHeader(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("https://www.imooc.com/user/setbindsns");

        String jsString = "document.getElementsByClassName('update-avator')[0].style.bottom='0'";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsString);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.className("js-avator-link")).click();

        String jsString2 = "document.getElementById('upload').style.display='block'";
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript(jsString2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("upload")).sendKeys("C:\\Users\\lenovo\\Pictures\\Saved Pictures\\583cedde8742f.jpg");

    }

    public static void main(String[] args){
        ActionSelenium action = new ActionSelenium();
        action.InitDriver();
        action.InputBox();
        //action.web_from();
        //action.rediobox();
        //action.checkBox();
        action.button();
        action.upHeader();
    }
}
