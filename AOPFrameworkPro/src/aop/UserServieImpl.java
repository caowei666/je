package aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AOP:面向切面编程
 * 切面：方法中的非核心业务代码
 * 一个方法的完整运行过程，即包含核心代码也包含切面
 * 为了把非核心业务代码从业务代码中分离出来，独立编写，好处是：这个切面代码可能是重复被使用
 * 让核心业务功能只关注核心代码
 *
 * 非核心业务代码（切面）
 * 切面的代码会在核心业务代码的哪些地方出现？
 * 1、前门出现（前置通知）
 * 2、后面出现（后置通知）
 * 3、前后出现（环绕通知）
 */
public class UserServieImpl implements UserService{
    private List<String> list = new ArrayList<>();
    @Override
    public void add(String name) {
        //在核心业务代码执行之前，记录开始时间
        //System.out.println("start add time:" + System.currentTimeMillis());

        list.add(name);  //核心业务代码
        System.out.println(Arrays.toString(list.toArray()));

        //在核心业务代码执行之后，记录结束时间
        //System.out.println("end add time:" + System.currentTimeMillis());
    }
}
