package codingke.singleton;

/**
 * 单例模式之懒汉式：
 * 1、定义一个私有构造器
 * 2、提供一个本类的对象引用
 * 3、提供一个获取本类对象的静态方法
 * 特点：在声明本类对象时不创建对象
 * 在第一次调用getInstance方法时创建对象，后续每次调用需要判断后才返回对象
 * 声明周期相对短，占用内存的时间相对短，调用时每次要判断，相对慢。
 *
 * 在我们写的类中，只有方法没有属性（工具类）
 * 那我们使用每次创建对象的方式来调用方法，和只用一个对象来调用方法  效果是一样的
 * 工具类通常被频繁使用
 *  创建对象过程：1、找到这个类的class 2、通过字节码来计算创建对象所需要的空间
 *  3、向堆内存申请空间，分配空间 4、在对应的空间中初始化变量
 *
 *  为什么要使用单例：
 *      目的是为了节省频繁的创建对象而带来的对内存的消耗
 *
 *  存在线程安全问题.s可能被实例化多次(使用同步块synchronized解决)，但带来了效率下降的问题
 *  解决方案：使用双检模式
 *
 *  volatile:关键字，在多线程开发中用于同步变量的状态
 *
 *  能不能用构造方法私有化+静态方法来代替单例模式？（Math就是这样）
 *      单例的好处：可以充分利用面向对象的特性：继承 封装 多态（重写）这些都能实现
 *      而静态方法：不依赖对象，因此，虽然可以继承，但不能重写，也无法实现多态
 */
public class SingleTon2 {
    //为了防止外部实例化本类对象
    private SingleTon2(){}
    private volatile static SingleTon2 s;
    public static SingleTon2 getInstance(){
        if(s == null){
            synchronized (SingleTon1.class){
                if(s == null){
                    s = new SingleTon2();
                }
            }
        }
        return s;
    }
    public void print(){
        System.out.println("懒汉式单例设计模式");
    }
}
