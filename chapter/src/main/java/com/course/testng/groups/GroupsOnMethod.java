package com.course.testng.groups;

import org.testng.annotations.*;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组测试方法1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组测试方法2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端测试方法3");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("beforeGroupsOnServer 这是运行在服务组方法之前的");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("beforeGroupsOnServer这是运行在服务组方法之后的");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("beforeGroupsOnClient这是运行在客户端组方法之前的");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("afterGroupsOnClient 这是运行在客户端方法之后的");
    }
}
