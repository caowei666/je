package codingke.factory;

/**
 * 工厂类
 */
public class ProductFactory {
    public static Product getProduct(String name){
        if(ProductType.PHONE.equals(name)){
            return new Phone();
        }else if(ProductType.COMPUTER.equals(name)){
            return new Computer();
        }else{
            return null;
        }
    }
}
