package proxy.dynamic;


import data.Cache;
import data.Order;
import proxy.OrderDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建代理对象的工厂类
 * InvocationHandler 接口实现代理对象要处理的事情
 */
public class CreateProxyFactory implements InvocationHandler {
    private Object target;  //被代理对象

    //创建代理对象的方法
    public Object create(Object target){
        this.target = target;
        /**
         * JDK提供创建代理类对象的方法参数
         * 1、类加载器
         * 2、代理对象的接口
         * 3、InvocationHandler（代理对象的处理器）
         */
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
        return proxy;
    }

    /**
     * 生成的代理对象要执行的代理对象要执行的业务
     * @param proxy  代理类对象
     * @param method 被代理对象的方法
     * @param args  被代理对象方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Order order = null;
        if (args != null) {
            int oid = (int)args[0];
            order = Cache.getInstance().getCache(oid);
            if(order == null){
                //调用真实的业务方法
                order = (Order) method.invoke(target, args);
                Cache.getInstance().putCache(order.getOid(),order);
            }
        }
        return order;
    }
}
