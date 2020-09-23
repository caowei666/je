import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-service.xml");
        //System.out.println(classPathXmlApplicationContext.getBean("helloService"));
        classPathXmlApplicationContext.start();
        System.out.println("服务发布成功");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
