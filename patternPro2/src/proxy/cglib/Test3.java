package proxy.cglib;

/**
 * JAVA api 动态代理和CGLIB实现动态代理的区别
 * 1、jdk api创建动态代理被代理对象要有接口，CGLIB不需要有接口
 * 2、jdk api创建代理类，动态生成一个class，加载到内存中
 * 3、CGLIB通过 ASM来直接生成一个字节码，性能要更高，ASM内部承载了JVM中javac的功能（底层）
 */
public class Test3 {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        OrderDaoObject dao = new OrderDaoObject();
        OrderDaoObject o = (OrderDaoObject)cglibProxy.create(dao);
        System.out.println(o.queryOrder(2));
        System.out.println("---第二次查询----");
        System.out.println(o.queryOrder(2));
    }
}
