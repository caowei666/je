package pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//ApplicationContextAware是BeanFactoryAware的子类
public class Master implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("我是master的setname方法");
        this.name = name;
    }

    public Master() {
        System.out.println("我是master的构造方法");
    }

    public Master(String name) {
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {    //用于设置bean的id的方法
        System.out.println("beanNameAware.setBeanName方法"+s);  //beanNameAware.setBeanName方法master
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {  //注入容器可以在这里拿到别的bean
        System.out.println("BeanFactoryAware.setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware.setBeanFactory");
    }

    public void init(){
        System.out.println("init方法");
    }
    public void close(){
        System.out.println("销毁");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁2");
    }
}
