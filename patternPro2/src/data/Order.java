package data;

public class Order {
    private int oid;
    private String orderInfo;
    private float total;
    private String orderDate;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Order() {
    }

    public Order(int oid, String orderInfo, float total, String orderDate) {
        this.oid = oid;
        this.orderInfo = orderInfo;
        this.total = total;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", orderInfo='" + orderInfo + '\'' +
                ", total=" + total +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
