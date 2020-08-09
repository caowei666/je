import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Dept;
import pojo.Employee;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MybatisTest {
    String resource = "mybatis-config.xml";
    Reader reader = null;
    SqlSession session = null;
    SqlSessionFactory sessionFactory = null;
    @Before
    public void open() throws IOException {
        reader = Resources.getResourceAsReader(resource);
        //构建sqlSession工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sessionFactory.openSession();
    }
    @After
    public void close(){
        session.close();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insert(){
        try {
            Dept dept = new Dept();
            dept.setName("koiuding4");
            session.insert("DEPT.addDept",dept);
            System.out.println(dept.getId());
            session.commit();  //提交事务
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();  //事物回滚
        }
    }
    @Test
    public void update(){
        try {
            Dept dept = new Dept();
            dept.setName("法外狂徒张三");
            dept.setId(36);
            int res = session.update("DEPT.updateDept",dept);
            System.out.println(res);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    @Test
    public void delete(){
        try {
            int res = session.delete("DEPT.deleteDept",36);
            System.out.println(res);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    @Test
    public void listAll(){
        List<Dept> list = session.selectList("DEPT.getDeptList");
        for (Dept d:list){
            System.out.println(list);
        }
    }
    @Test
    public void getListAll(){
        List<Employee> list = session.selectList("EMP.getAllEmpListWithList");
        for (Employee e:list){
            System.out.println(list);
        }
    }

    @Test
    public void listAll2(){
        List<Dept> list = session.selectList("DEPT.getDeptWithEmp");
        for (Dept d:list){
            System.out.println(d);
            if(d.getEmployees()!=null){
                for (Employee e:d.getEmployees()){
                    System.out.println(e);
                }
            }
        }
    }
    @Test
    public void criteria(){
        Dept dept = new Dept();
//        dept.setId(1);
        dept.setName("xx");
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        List<Dept> list = session.selectList("DEPT.getDeptListwithtiaojian",dept);
        for (Dept dept1:list){
            System.out.println(dept1);
        }
    }
    @Test
    public void listCircle(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("张三");
        List<Employee> employees = session.selectList("EMP.getAllEmpList",employee);
        for (Employee employee1:employees){
            System.out.println(employee1);
        }
    }
    @Test
    public void getDeptCount(){
        Dept dept = new Dept();
//        dept.setName("xx");
        int pageNum = 2;
        int pageSize = 2;
        int count = session.selectOne("DEPT.getDeptCount",dept);
        int total = count%pageSize==0?(count/pageSize):(count/pageSize+1);
        System.out.println(total);
        int offset = (pageNum-1)*pageSize;
        System.out.println(count);
        List<Dept> list = session.selectList("DEPT.getDeptCount1",dept);
        for (Dept dept1:list){
            System.out.println(dept1);
        }
    }
    @Test
    public void limitHelper(){
        Dept dept = new Dept();
        PageHelper.startPage(1,2);
        List<Dept> list = session.selectList("DEPT.getDeptListwithtiaojian",dept);
        PageInfo<Dept> deptPageInfo = new PageInfo<>(list,5);
        System.out.println("总页数："+deptPageInfo.getPages());
        System.out.println("总条数："+deptPageInfo.getTotal());
        System.out.println("当前页码："+deptPageInfo.getPageNum());
        System.out.println("每页几条"+deptPageInfo.getSize());
        System.out.println("是不是第一页"+deptPageInfo.isIsFirstPage());
        System.out.println("导航栏："+ Arrays.toString(deptPageInfo.getNavigatepageNums()));
        for (Dept dept1:list){
            System.out.println(dept1);
        }
    }

    @Test
    public void testAnon(){
        DeptMapper mapper = session.getMapper(DeptMapper.class);  //获取代理对象
//        mapper.addDept("注解");
        Dept dept = new Dept();
        dept.setId(38);
        dept.setName("hehe");
//        mapper.update(dept);
//        mapper.deleteById(38);
        Dept deptById = mapper.getDeptById(35);
        System.out.println(deptById);
        session.commit();
    }

    @Test
    public void genr(){
        generator.mapper.DeptMapper mapper = session.getMapper(generator.mapper.DeptMapper.class);
//        generator.pojo.Dept dept = mapper.selectByPrimaryKey(2);
//        System.out.println(dept);
    }
    @Test
    public void testCache(){
        //一级缓存 同一个session 相同条件只查询一次(默认的缓存)
        Dept dept = session.selectOne("DEPT.getDeptById",1);
//        SqlSession session2 = sessionFactory.openSession();
        session.delete("DEPT.deleteDept",32);
        session.commit();
        Dept dept2 = session.selectOne("DEPT.getDeptById",1);
        System.out.println(dept);
        System.out.println(dept2);
    }
    @Test
    public void testCache2(){
        //二级缓存
        Dept dept = session.selectOne("DEPT.getDeptById",1);
        session.close();    //第一个session需要关闭
        SqlSession session2 = sessionFactory.openSession();
        Dept dept2 = session2.selectOne("DEPT.getDeptById",1);
        System.out.println(dept);
        System.out.println(dept2);
    }
}
