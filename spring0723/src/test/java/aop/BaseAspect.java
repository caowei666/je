package aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BaseAspect implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object res = null;
        if(isIntercept(method,args)){  //需要增强

            try {
                before();
                res = methodProxy.invokeSuper(obj, args);
                after();
            } catch (Throwable throwable) {
                error(throwable);
                throwable.printStackTrace();
                throw  throwable;
            }finally {
                end();
            }

        }else{
            res = methodProxy.invokeSuper(obj,args);
        }
        return res;
    }
    //开始增强
    public void begin(){

    }
    //前置
    public void before(){

    }
    //后置
    public void after(){

    }
    //异常增强
    public void error(Throwable e){

    }
    //最终增强
    public void end(){

    }
    public boolean isIntercept(Method method,Object []args){
        return true;
    }
}
