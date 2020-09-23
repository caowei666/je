import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HelloService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloService helloService = applicationContext.getBean(HelloService.class);
        System.out.println(helloService.sayHello());
    }
}
