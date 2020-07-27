package aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.beans.Expression;
import java.util.Arrays;

@Aspect
public class AspectjAdvice {
    @Pointcut("execution(* aspectJ.AspectAdviceTarget.testAdvice(..))")
    public void myPoint(){

    }
    @Before("myPoint()")
    public void before(JoinPoint point){
        System.out.println("----我是前置增强---");
        System.out.println(point.getTarget().getClass());   //切入的类
        System.out.println(point.getSignature());   //切入到的方法
        System.out.println(Arrays.toString(point.getArgs()));
    }
    @AfterReturning(pointcut = "myPoint()",returning = "returnVal")
    public void afterReturn(Object returnVal){
        System.out.println("----后置增强---");
        System.out.println("返回值："+returnVal);
    }
    @AfterThrowing(pointcut = "execution(* aspectJ.AspectAdviceTarget.testException())",throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println("---异常抛出增强---");
        System.out.println(ex);
    }
    @After("myPoint()")
    public void after(){
        System.out.println("---after---");
    }
    @Around("execution(* aspectJ.AspectAdviceTarget.around(..))")
    public void around(ProceedingJoinPoint point){
        System.out.println("环绕前置");
        try {
            point.proceed();
            System.out.println("环绕后置");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕异常");
        }
    }
}
