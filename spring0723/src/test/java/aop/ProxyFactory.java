package aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class ProxyFactory {
    public static <T> T createProxy(Class<?> targetClass, final MethodInterceptor methodInterceptor){
        return (T) Enhancer.create(targetClass,methodInterceptor);
    }
}
