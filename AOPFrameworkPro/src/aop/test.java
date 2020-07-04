package aop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * AOP
 * 1、装配对象：通过反射和内省技术，从配置文件中获取类信息，来创建对象，并组装对象（对象注入）
 * 2、面向切面编程：通过代理模式，来实现业务方法中，核心业务与非核心业务分离，把核心业务抽象出来，目的是高内聚，低耦合
 *      切面可以重复利用，更加灵活。
 */
public class test {
    public static void main(String[] args) {
//        UserServieImpl userServiceImpl = new UserServieImpl();
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//
//        proxyFactoryBean.setTarget(userServiceImpl);  //要代理的对象
//        proxyFactoryBean.setAdvice(new LogTimeAdvice()); //设置切面通知

        InputStream in = null;
        try {
            in = new FileInputStream("bean.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("aop/bean.properties");
        BeanFactory beanFactory = new BeanFactory(in);
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)beanFactory.getBean("bean");

        UserService  proxy = (UserService)proxyFactoryBean.getProxy();
        proxy.add("Sunny");
        proxy.add("nini");
        proxy.add("awei");
    }
}
