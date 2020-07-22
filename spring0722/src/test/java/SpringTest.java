import anno.AppConfig;
import anno.Bird;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Master;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)   //我要使用spring的junit
//@ContextConfiguration({"classpath:spring-test.xml"})    //测试要使用的文件
@ContextConfiguration(classes = AppConfig.class)
public class SpringTest {
//    @Autowired   //从spring拿一个bean,按类型获得bean
//    private Master master;
//    @Test
//    public void testMaster() {
//        master.sayHello();
//    }

    @Qualifier("bird")
    @Resource   //两个注解一起用
    Bird bird1;
    @Test
    public void test(){
        System.out.println(bird1);
    }
}
