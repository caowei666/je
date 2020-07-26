package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class AroundService implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object terget = methodInvocation.getThis();  //被代理的对象
        Method method = methodInvocation.getMethod();  //要执行的方法
        Object[] args = methodInvocation.getArguments();

        try {
            System.out.println("前置");
            Object res = methodInvocation.proceed();
            System.out.println(terget+"的"+method.getName());
            System.out.println("后置");
            return res;
        } catch (Throwable e) {
            System.out.println("出异常了");
            throw e;
        } finally {
            System.out.println("finally");
        }
    }
}
