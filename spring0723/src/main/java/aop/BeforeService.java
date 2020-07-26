package aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeService implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("开始前置增强");
        System.out.println(o +"的"+method.getName());
        System.out.println("前置增强结束");
    }
}
