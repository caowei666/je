package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
    @RequestMapping("/ex.html")
    public String exceptionTest(Integer type) throws Exception{
        switch (type){
            case 1:
                throw new NullPointerException("测试空指针异常");
            case 2:
                throw new ClassCastException("测试空指针异常");
            case 3:
                throw new IndexOutOfBoundsException("测试空指针异常");
        }
        return "index";
    }
}
