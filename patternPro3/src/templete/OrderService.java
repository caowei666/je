package templete;

public class OrderService extends BaseAction {
    @Override
    public void execute(String method) {
        if("add".equals(method)){
            System.out.println("执行了添加数据操作");
        }else if("del".equals(method)){
            System.out.println("执行了删除数据操作");
        }
    }
}
