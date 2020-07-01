package adapter;

/**
 * 适配器模式：将一个类的接口转换成客户希望的另一个接口
 * 这个模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 *
 * 适配器类要完成什么功能？
 * 1、适配器要把哪个接口转换成另一个接口（把PowerB转换成PowerA）
 * 2、适配器需要转换成什么接口那就需要实现什么接口
 * 3、原接口是谁，需要把这个接口作为属性传递进来
 */
public class Adapter implements PowerA {
    private PowerB powerB;   //要转换的接口
    public Adapter(PowerB powerB){
        this.powerB = powerB;
    }
    private PowerC powerC;
    public Adapter(PowerC powerC){
        this.powerC = powerC;
    }
    @Override
    public void insert() {
        if(powerC == null){
            powerB.connection();
        }else {
            powerC.out();
        }
    }
}
