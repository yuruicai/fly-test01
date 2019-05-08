package com.selenium.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testTable {
    public static void main(String[] args){
        WebDriver driver;
        driver = new FirefoxDriver();
        String url = "C:\\Users\\lenovo\\IdeaProjects\\Test\\src\\main\\resources\\html\\table.html";
        driver.get(url);
        //定位table
        WebElement Table = driver.findElement(By.tagName("table"));
        Table.findElement(By.tagName("tr"));
    }
}
