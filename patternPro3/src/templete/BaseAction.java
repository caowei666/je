package templete;

public abstract class BaseAction {
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
