package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {
    private MovieActor target;   //被代理的对象
    public JdkProxy(){
        this.target = new MovieActor();
    }
    public Object getProxyInstance(){
        Class aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("经纪人，谈薪水，签合同");
                Object res = method.invoke(target, args);
                System.out.println("经纪人收起");
                return res;
            }
        });
    }
}
