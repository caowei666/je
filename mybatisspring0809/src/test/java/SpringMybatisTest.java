import com.test.dao.DeptDAO;
import com.test.pojo.Dept;
import com.test.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    @Test
    public void testSelect(){
//        DeptDaoImpl deptDao = (DeptDaoImpl)applicationContext.getBean("deptDao");
//        Dept dept = deptDao.getDeptById(1);
//        System.out.println(dept);
    }
    @Test
    public void testSelect1(){
//        DeptDAO deptDao = (DeptDAO)applicationContext.getBean("deptDAO");   //通过id获取bean
        DeptService deptService = applicationContext.getBean(DeptService.class); //通过类获取bean
//        Dept dept = deptDao.getDeptById(1);
//        System.out.println(dept);
        Dept dept = new Dept();
        dept.setName("service");
//        int i = deptDao.addDept(dept);
        deptService.add(dept);
//        System.out.println(i);
    }

}
