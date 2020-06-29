package codingke.singleton;

/**
 * 单例模式之饿汉式：
 * 1、定义一个私有构造器
 * 2、提供一个本类的对象引用
 * 3、提供一个获取本类对象的静态方法
 * 特点：在声明本类对象时就创建对象
 * 那么对象的声明周期成，占内存时间长，调用时快
 */
public class SingleTon1 {
    //为了防止外部实例化本类对象
    private SingleTon1(){}
    private static SingleTon1 s = new SingleTon1();
    public static SingleTon1 getInstance(){
        return s;
    }
    public void print(){
        System.out.println("饿汉式单例设计模式");
    }
}
