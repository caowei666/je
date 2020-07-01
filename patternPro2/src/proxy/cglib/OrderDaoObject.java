package proxy.cglib;

import data.DB;
import data.Order;

public class OrderDaoObject {
    public Order queryOrder(int oid) {
        //根据oid查询数据库，返回订单对象
        DB db = new DB();
        Order order = db.getOrder(oid);
        return order;
    }
}
