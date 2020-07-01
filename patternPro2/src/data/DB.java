package data;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private static List<Order> list = new ArrayList<>();
    static {
        list.add(new Order(1,"毛巾三条",45,"2020-2-1"));
        list.add(new Order(2,"小纸巾10包",12,"2020-1-21"));
        list.add(new Order(3,"洗发水一瓶",32,"2020-1-30"));
        list.add(new Order(4,"红牛一箱",36,"2020-2-2"));
        list.add(new Order(5,"哈啤2箱",120,"2020-2-3"));
    }

    public Order getOrder(int oid){
        System.out.println("从数据库查找数据...");
        for (Order order:list){
            if(order.getOid() == oid){
                return order;
            }
        }
        return null;
    }
}
