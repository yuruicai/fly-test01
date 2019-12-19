package com.selenium.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class FuxiSelenium3 {
    public WebDriver driver;
    public void Init(){

        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.imooc.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void Login(){

        WebElement user = driver.findElement(By.className("xa-emailOrPhone"));
        user.sendKeys("17816873856");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Summer123");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("moco-btn")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void Rario(){
        driver.get("https://www.imooc.com/user/setprofile");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //先通过id找到编辑个人信息的整个表单；在通过性别name找到性别单选框的list
        WebElement userForm = driver.findElement(By.id("profile"));
        List<WebElement> SexList = userForm.findElements(By.name("sex"));

        for(WebElement sex:SexList){
            String attribute = sex.getAttribute("value");
            System.out.println(attribute);
            //System.out.println("----"+sex.getAttribute("value"));

            //女的value是2，如果不是2，则跳出，是2则点击（后期可优化，如果2已经点中了，就不点）
            if (!"2".equals(attribute)){
                break;
            }else {
                sex.click();
            }
        }

         //List<WebElement> SexList= driver.findElements(By.name("sex"));
        //SexList.get(2).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    public void CheckBox(){
        WebElement Box = driver.findElement(By.id("auto-signin"));
        System.out.println(Box.isEnabled());
        System.out.println(Box.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Box.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    public void Button(){
        //document.getElementsByClassName("moco-btn-red")[0].style.display="None";
        WebElement ButtonElement = driver.findElement(By.className("moco-btn-red"));
        System.out.println(ButtonElement.isDisplayed());
        System.out.println(ButtonElement.isEnabled());
        System.out.println("---------->");
        String JsString = "document.getElementsByClassName(\'moco-btn-red\')[0].style.display=\'None\';";
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript(JsString);
        WebElement ButtonElement1 = driver.findElement(By.className("moco-btn-red"));
        System.out.println(ButtonElement1.isEnabled());
        System.out.println(ButtonElement1.isDisplayed());
        System.out.println("---------->");
    }
    public void UpFile(){
        driver.get("https://www.imooc.com/user/setbindsns");

        //上传头像，移动鼠标事件，先元素定位展示更换头像按钮
        WebElement HeadPng = driver.findElement(By.className("avator-mode"));
        Actions action = new Actions(driver);
        //.perform是需要提交；之后更换头像按钮才会展示
        action.moveToElement(HeadPng).perform();
        driver.findElement(By.className("js-avator-link")).click();

        //上传头像按钮中的浏览，被隐藏，执行下面代码展示出来，然后再通过id元素定位点击浏览按钮
        String JsString1 = "document.getElementById(\'upload\').style.display = \'block\'";
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript(JsString1);

        //sendkeys只针对标签是input类型
        driver.findElement(By.id("upload")).sendKeys("C:\\Users\\lenovo\\Desktop\\58e72540c5fcd.jpg");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.close();
    }
    public void UpFileTwo() throws AWTException {
        driver.get("https://www.imooc.com/user/setbindsns");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //上传头像，移动鼠标事件，先元素定位展示更换头像按钮
        WebElement HeadPng = driver.findElement(By.className("avator-mode"));
        Actions action = new Actions(driver);
        //.perform是需要提交；之后更换头像按钮才会展示
        action.moveToElement(HeadPng).perform();
        driver.findElement(By.className("js-avator-link")).click();

        //上传头像按钮中的浏览，被隐藏，执行下面代码展示出来，然后再通过id元素定位点击浏览按钮
        String JsString1 = "document.getElementById(\'upload\').style.display = \'block\'";
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript(JsString1);

        driver.findElement(By.id("upload")).click();

        //内存中拿到这个图片文件的地址
        StringSelection SelectJpg = new StringSelection("C:\\Users\\lenovo\\Desktop\\58e72540c5fcd.jpg");

        //将这个文件放在剪切板中
        Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
        sysc.setContents(SelectJpg , null);

        /**
         * 做Ctrl+V操作
         * */
        Robot robot = new Robot();
        //按下动作
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        //释放键盘
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        robot.keyPress(KeyEvent.VK_ENTER);


        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.close();
    }
    public void WebForm(){
        WebElement user = driver.findElement(By.className("xa-emailOrPhone"));
        user.sendKeys("17816873856");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Summer123");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("signup-form")).submit();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void SelectOption(){
        driver.get("https://www.imooc.com/user/setprofile");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //先通过id找到编辑个人信息的整个表单；在通过性别name找到性别单选框的list
        WebElement userForm = driver.findElement(By.id("profile"));
        userForm.findElement(By.id("job")).click();
        //通过index方法选择；先找到列表
        List<WebElement> JobList = userForm.findElements(By.tagName("option"));
        System.out.println(JobList.size());
        JobList.get(5).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }

    public void SelectOptionSelenium(){
        driver.get("https://www.imooc.com/user/setprofile");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //先通过id找到编辑个人信息的整个表单；在通过性别name找到性别单选框的list
        WebElement userForm = driver.findElement(By.id("profile"));
        WebElement job = userForm.findElement(By.id("job"));
        //通过selenium自带的select方法，选择下拉框中的元素
        Select DownList = new Select(job);
        //DownList.selectByIndex(3);
        DownList.selectByValue("18");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DownList.selectByVisibleText("页面重构设计");
        //deselectBy 方法适用于下拉框多选
        // DownList.deselectByIndex(18);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.close();
    }
    public  void MoseAction(){
        driver.get("https://www.imooc.com/");
        //WebElement LoginElement = driver.findElement(By.id("js-signin-btn"));
        Actions MoseActions = new Actions(driver);
        //鼠标左击事件，点击登录按钮
        //MoseActions.click(LoginElement).perform();

        /**
         * 先定位需要悬停的菜单栏，鼠标悬停在左侧菜单栏，然后左侧展示出一个大列表，在大列表中找到自己想要找的元素
         * */
        List<WebElement> MenuElementList = driver.findElements(By.className("item"));
        WebElement MobileElement = MenuElementList.get(1);
        MoseActions.moveToElement(MobileElement).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("小程序")).click();

    }

    /**
     * Iframe处理及无焦点问题分析
     * */
    public void SwithIframe(){
        //id = ueditor_0
        driver.get("https://www.imooc.com/article/publish#");
        try{
            driver.findElement(By.id("ueditor_0")).sendKeys("Mushishi");
        }catch (Exception e){
            System.out.println("定位直接输入错误");
        }

        WebElement IframeElement = driver.findElement(By.id("ueditor_0"));
        driver.switchTo().frame(IframeElement);
        WebElement Ueditor = driver.findElement(By.tagName("p"));
        //Ueditor.click();
        Actions MoseActions = new Actions(driver);
        MoseActions.moveToElement(Ueditor).click().sendKeys("This is real test!").perform();
        //MoseActions.sendKeys("test 2222").perform();
        //Ueditor.sendKeys("this is test!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }



    public static void main(String args[]) throws AWTException {
        FuxiSelenium3 fuxiSelenium3 = new FuxiSelenium3();
        fuxiSelenium3.Init();
        fuxiSelenium3.Login();
        //fuxiSelenium3.Rario();
        //fuxiSelenium3.UpFile();
        //fuxiSelenium3.UpFileTwo();
        //fuxiSelenium3.Button();
        //fuxiSelenium3.CheckBox();
        //fuxiSelenium3.WebForm();
        //fuxiSelenium3.SelectOption();
        //fuxiSelenium3.SelectOptionSelenium();
        //fuxiSelenium3.MoseAction();
        fuxiSelenium3.SwithIframe();
    }
}
