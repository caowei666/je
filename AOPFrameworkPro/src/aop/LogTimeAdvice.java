package aop;

public class LogTimeAdvice implements Advice{

    @Override
    public void beforeAdvice() {
        //在核心业务代码执行之前，记录开始时间
        System.out.println("start add time:" + System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        //在核心业务代码执行之后，记录结束时间
        System.out.println("end add time:" + System.currentTimeMillis());
    }
}
