package com.selenium.day2;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class testDriver {
    public static void main(String [] args){
        //    firefox浏览器启动
        WebDriver driver;
         //设置环境变量，添加firefox的安装路径
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //实例化一个对象firefox
        driver = new FirefoxDriver();
        String testUrl = "http://www.baidu.com";
        driver.get(testUrl);
        //driver.quit();


        /**
        WebDriver driver;
        //设置环境变量，添加chrome的安装路径
        // System.setProperty("webdriver.chrome.driver","E:\\webdriver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        String testUrl = "http://www.baidu.com";
        driver.get(testUrl);
        driver.quit();

        WebDriver driver;
        System.setProperty("webdriver.ie.driver","D:\\webdriver\\IEDriverServer_x64_2.46.0\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        String testUrl = "http://www.baidu.com";
        driver.get(testUrl);
        driver.quit();
         **/

    }
}
