package codingke.factory;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * 工厂模式：让对象直接的强依赖，转换成对工厂对象的依赖
 */
public class Test {
    public static void main(String[] args) {
        //Product p = new Phone();
        //p.work();

        Product p = ProductFactory.getProduct(ProductType.COMPUTER);
        p.work();

        //工厂模式来获取对象 例如：
        Calendar instance = Calendar.getInstance();
        ResourceBundle bundle = ResourceBundle.getBundle("codingke.strategy.config");
    }
}
