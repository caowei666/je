package com.caowei.test;

import com.caowei.Operation;
import org.junit.*;

public class OperationTest {
    private static Operation opt;
//    @Before   //AOP切面编程
//    public void methodBefore(){
//        opt = new Operation();
//        System.out.println("测试方法之前");
//    }
//    @After
//    public void methodAfter(){
//        opt = null;
//        System.out.println("测试方法之后");
//    }
    @BeforeClass
    public static void BeforeClass(){
        opt = new Operation();
        System.out.println("所有方法测试之前");
    }
    @AfterClass
    public static void AfterClass(){
        opt = null;
        System.out.println("所有方法之后");
    }
    @Test
    public void testAdd(){
//        Operation opt = new Operation();
        int result = opt.add(20,20);
        System.out.println(result);
        Assert.assertEquals(40,result);
    }
    @Test
    public void testSub(){
//        Operation opt = new Operation();
        int sub = opt.sub(30, 10);
        System.out.println(sub);
        Assert.assertEquals(20,sub);
    }
}
