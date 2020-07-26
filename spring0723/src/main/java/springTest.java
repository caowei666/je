import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Actor;
import pojo.Master;


//AOP面向切面编程
//spring aop底层原理：动态代理设计模式：有实现接口用的JDK代理，没有实现接口用的cglib代理
public class springTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
//        Master bean = classPathXmlApplicationContext.getBean(Master.class);
//        System.out.println(bean.getName());
//        classPathXmlApplicationContext.close();
//        我是master的构造方法                      //new创建对象
//        我是master的setname方法                   //设置属性
//        beanNameAware.setBeanName方法master       //设置id
//        BeanFactoryAware.setBeanFactory           //设置容器
//        ApplicationContextAware.setBeanFactory    //设置容器
//        postProcessBeforeInitialization初始化之前  //初始化前
//        init方法                                    //初始化
//        postProcessAfterInitialization初始化之后   //初始化之后
//        我是master的setname方法
//        李四
//        销毁2                                       //销毁
//        销毁                                        //销毁（两种方式）
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Actor bean = classPathXmlApplicationContext.getBean(Actor.class);
        //后置增强在有异常的时候不生效
        try {
            bean.play("caowei");
        } catch (Exception e) {
            e.printStackTrace();
        }
        classPathXmlApplicationContext.close();
    }
}
