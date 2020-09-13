import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-service.xml");
//        System.in.read();
    }
}
