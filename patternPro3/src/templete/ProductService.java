package templete;

public class ProductService extends BaseAction{
    @Override
    public void execute(String method) {
        if("add".equals(method)){
            System.out.println("产品入库成功");
        }else if("update".equals(method)){
            System.out.println("产品信息修改成功");
        }
    }
}
