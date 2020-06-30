package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Bean:豆（相对完整的一个整体，也是相对独立），所以我们把一个类成为一个java Bean
 *ProxyFactoryBean：用来创建代理对象的工厂类
 * AOP的核心是动态代理
 */
public class ProxyFactoryBean implements InvocationHandler {  //动态代理
    private Object target;  //被代理对象
    private Advice advice;  //切面接口

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Object getProxy(){
        //参数：1、类加载器，2、目标对象的接口集合，3、处理器InvocationHandler
        Object proxy =   Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在此处完成业务代码和切面代码的组合业务
        advice.beforeAdvice();

        Object obj = method.invoke(target, args);

        advice.afterAdvice();
        return obj;
    }
}
