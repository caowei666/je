package proxy.dynamic;

import data.Order;
import proxy.OrderDao;
import proxy.OrderDaoImpl;

public class test2 {
    public static void main(String[] args) {
        OrderDao dao = new OrderDaoImpl();
        CreateProxyFactory createProxyFactory = new CreateProxyFactory();
        OrderDao proxy = (OrderDao)createProxyFactory.create(dao);
        Order order = proxy.queryOrder(2);
        System.out.println(order);
        System.out.println("----第二次查询---");
        Order order1 = proxy.queryOrder(2);
        System.out.println(order1);
    }
}
