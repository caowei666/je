package templete;
/**
 * 策略模式与模板方法
 * 抽象的粒度不同
 * 策略：把可变的行为抽象出来
 * 模板：把行为中的某个步骤抽象出来
 */
public abstract class BaseAction {
    //模板方法
    //定义了方法的逻辑步骤，把不确定的步骤延迟都子类实现
    public void action(String name,String method){
        if("admin".equals(name)){
            //可以执行
            execute(method);
        }else {
            //不能执行
            System.out.println("你没有该操作的权限");
        }
    }

    public abstract void execute(String method);
}
