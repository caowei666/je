package aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ExceptionService implements ThrowsAdvice {
    public void afterThrowing(Method method,Object[] args,Object target,Exception e){
        System.out.println("异常抛出增强start");
        System.out.println(target+"的"+method.getName()+"方法发生异常"+e.getMessage());
        System.out.println("异常抛出end");
    }
}
