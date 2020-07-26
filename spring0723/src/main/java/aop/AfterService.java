package aop;

import org.aspectj.lang.annotation.After;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterService implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("后置增强");
    }
}
