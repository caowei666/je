package proxy.cglib;

import data.Cache;
import data.Order;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;

    public Object create(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();   //生成代理对象的生成类（工具类）
        enhancer.setSuperclass(this.target.getClass());  //设置代理类的父类
        enhancer.setCallback(this);  //设置代理类的处理方法
        enhancer.setClassLoader(this.target.getClass().getClassLoader());  //设置类加载器
        Object obj = enhancer.create();  //创建代理对象
        return obj;
    }

    //生成的代理对象处理的业务方法
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
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
