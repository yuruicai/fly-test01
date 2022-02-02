package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 run!");
        throw new RuntimeException();
    }

    //test2依赖test1，如果test1失败，test2不执行,(test1为test2的前置条件;如果被依赖的1失败了，2将忽略执行)
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run!");
    }
}
