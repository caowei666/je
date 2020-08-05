package controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dept;

import java.util.HashMap;
import java.util.Map;

@RestController   //类中所有方法加上了@RequestBody
@RequestMapping("/rest")
public class RestTest2Controller {
    @RequestMapping("test1")
    public Dept test1(){
        return new Dept();   //返回的xml格式  因为Dept被标记为xml
    }
    @RequestMapping("test2")
    public Map<String,Object> test2(){
        Map<String,Object> res = new HashMap<>();
        res.put("key1",123);
        return res;   //返回json格式，默认是json格式
    }
}
