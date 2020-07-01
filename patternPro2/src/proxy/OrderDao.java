package proxy;

import data.Order;

public interface OrderDao {
    public Order queryOrder(int oid);
}
