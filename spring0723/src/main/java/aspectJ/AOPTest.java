package aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        AspectAdviceTarget bean = applicationContext.getBean(AspectAdviceTarget.class);
//        bean.testAdvice("caowei",19);
        try {
//            bean.testException();
            bean.around();
        } catch (Exception e) {
//            e.printStackTrace();
        }
//        ----我是前置增强---
//        class aspectJ.AspectAdviceTarget
//        String aspectJ.AspectAdviceTarget.testAdvice(String,Integer)
//                [caowei, 19]
//        测试方法:caowei,19
//        ----后置增强---
//                返回值：测试方法返回
//        ---异常抛出增强---
//                java.lang.Exception: 我是手动异常
    }
}
