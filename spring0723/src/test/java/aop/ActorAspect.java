package aop;

import java.lang.reflect.Method;

public class ActorAspect extends BaseAspect{
    @Override
    public boolean isIntercept(Method method, Object []args){
        return method.getName().equals("play");
    }
    @Override
    public void before(){
        System.out.println("表演前准备");
    }

}
