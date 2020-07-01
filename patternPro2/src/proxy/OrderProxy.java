package proxy;

import data.Cache;
import data.Order;

/**
 * 订单代理对象
 *
 * 实现一个静态代理需要：
 * 1、实现一个业务接口；
 * 2、绑定一个具体的被代理对象
 * 3、接口业务方法中，实现代理对象要完成的具体的事情
 */
public class OrderProxy implements OrderDao {
    private OrderDao target;//目标对象（被代理对象）

    public OrderProxy(OrderDao target){
        this.target = target;
    }

    //用来实现目标对象控制
    @Override
    public Order queryOrder(int oid) {

        Cache cache = Cache.getInstance();
        Order order = cache.getCache(oid);  //从缓存中查询订单
        if (null==order) {
            order = target.queryOrder(oid);  //从数据库中查询订单
            cache.putCache(order.getOid(),order);   //把订单放入缓存中
        }
        return order;
    }
}
