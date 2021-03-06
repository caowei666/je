package controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.Dept;
import pojo.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class ParamBindController {
    @RequestMapping(method = RequestMethod.GET, value = "entity.html", produces = "application/json")
    public ResponseEntity<Dept> getEntity(RequestEntity<Dept> requestEntity){
        String header = requestEntity.getHeaders().getFirst("MyHeader");
        System.out.println(header);
        Dept dept = new Dept();
        dept.setName("bbbb");
        HttpHeaders headers = new HttpHeaders();
        headers.set("myRestHeader","aaaaa");
        ResponseEntity<Dept> responseEntity = new ResponseEntity<>(dept,headers, HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping("p1.html")
//    参数required默认是true
    public String test(@RequestParam(name="num",required = false,defaultValue = "1") Integer num){
        System.out.println(num);
        return "/test.jsp";
    }
    @RequestMapping("add.html")
    public String add(Dept dept){
        System.out.println(dept);
        return "test.jsp";
    }
    @RequestMapping("addEmp.html")
    public String add(Employee emp){
        System.out.println(emp);
        return "test.jsp";
    }
    @RequestMapping("param6.html")
    public String param6(int[] answer){
        System.out.println(Arrays.toString(answer));
        return "test.jsp";
    }
    @RequestMapping("param7.html")
    public String param7(@RequestBody List<String> list){
        for (String s:list){
            System.out.println(s);
        }
        return "test.jsp";
    }
    @RequestMapping("param8.html")
    public String param8(@RequestBody List<Dept> depts){
        for (Dept d:depts){
            System.out.println(d);
        }
        return "test.jsp";
    }
    @RequestMapping("param9.html")
    public String param9(@RequestBody Dept dept){
        System.out.println(dept);
        if(dept.getEmployees()!=null){
            for (Employee employee:dept.getEmployees()){
                System.out.println(employee);
            }
        }
        return "test.jsp";
    }
    @RequestMapping("param10.html")
    public String param9(@RequestBody List<Map<String,Object>> list){
        for (int i = 0; i < list.size(); i++) {
            Map<String,Object> map = list.get(i);
            System.out.println(map);
            System.out.println("=========");
        }
        return "test.jsp";
    }
    @RequestMapping("api.html")
    public String spi(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        session.setAttribute("sobj","我是sessin");
        return  "test.jsp";
    }
}
