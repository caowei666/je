package aspectJ;

public class AspectAdviceTarget {
    public String testAdvice(String param1,Integer param2){
        System.out.println("测试方法:"+param1+","+param2);
        return "测试方法返回";
    }
    public void testException() throws Exception{
        throw new Exception("我是手动异常");
    }

    public void around(){
        System.out.println("around()");
    }
}
