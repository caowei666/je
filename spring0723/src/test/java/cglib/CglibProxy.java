package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;
    public CglibProxy(){
        this.target = new MovieActor();
    }
    //给目标对象创建一个代理对象
    public Object getProxyInstane(){
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("谈薪资");
        Object res = method.invoke(target, objects);
        System.out.println("收钱");
        return res;
    }
}
