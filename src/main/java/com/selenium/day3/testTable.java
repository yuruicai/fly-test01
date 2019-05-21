package com.selenium.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class testTable {
    public static void main(String[] args){
        String str = "row 1, cell 2";
        String str1 = "row 2, cell 2";
        WebDriver driver;
        driver = new FirefoxDriver();
        String url = "C:\\Users\\lenovo\\IdeaProjects\\Test\\src\\main\\resources\\html\\table.html";
        driver.get(url);
        //定位table
        WebElement Table = driver.findElement(By.tagName("table"));
        //findElement他是定位单一一个元素的方法，定位一组方法我们需要使用findElements
        // Table.findElement(By.tagName("tr"));
        List<WebElement> rows = Table.findElements(By.tagName("tr"));
        for (WebElement row:rows){
            List<WebElement> tds = row.findElements(By.tagName("td"));
            for (WebElement td:tds){
                String value = td.getText();
                if (value.equals(str)||value.equals(str1)){
                    System.out.println(value);
                }else {
                    System.out.println("error"+"\n");
                }
            }
        }
    }
}
