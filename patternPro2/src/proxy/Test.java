package proxy;

import data.Order;

public class Test {
    public static void main(String[] args) {
        OrderDao dao = new OrderDaoImpl();
        Order order = dao.queryOrder(2);
        System.out.println(order);
        System.out.println("-----------");
        //用到缓存
        OrderProxy proxy = new OrderProxy(dao);
        Order order1 = proxy.queryOrder(2);
        System.out.println(order1);
        System.out.println("第二次查询");
        Order order2 = proxy.queryOrder(2);
        System.out.println(order2);
    }
}
