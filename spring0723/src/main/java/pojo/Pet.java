package pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Pet implements BeanPostProcessor {
    @Override   //初始化一个bean之前
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization初始化之前");
        return bean;
    }
    public Pet(){
        System.out.println("pet的构造方法");
    }
    public void init(){
        System.out.println("初始化");
    }
    @Override   //初始化一个bean之后
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization初始化之后");
        if(bean instanceof Master){
            Master master = (Master)bean;
            master.setName("李四");
        }
        return bean;
    }
}
