package codingke.strategy;

import java.io.IOException;
import java.util.Properties;

/**
 * 策略模式：封装变化，把可变的功能单独封装起来，目的是为了更好的适应变化
 * 思考：当一个功能会发送变化时，我们为了更好的去适应变化，我们原则需要把可变化的功能封装起来
 *      定义一个算法簇（策略）,多态的概念
 *      类A调用类B，那么我们认为A类依赖了B类（耦合）
 *      在我们的软件开发中，我们的原则是解耦
 *
 *  把业务功能实现类的修改放在配置文件（propertier,xml）,而不是在代码中，为什么？
 *  如果是修改代码，那么以为者重写编译，重新部署（上传服务器）
 *  如果是修改配置文件，只需要重启服务器
 *
 *  使用解耦的方法来解决问题？
 *  让软件更加有利于维护和可扩展性，去牺牲部分性能
 *
 *  策略模式的应用：数据库操作封装 微信扫码登录注册绑定操作
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Duck duck = new Duck("唐老鸭");
        //duck.say();

        //ISave iSave = new FileSave();
        //iSave.save("心动");


        DataContext dc = new DataContext(DataContext.getSave());
        dc.save("心动");
    }
}
