package decorator;

/**
 * 具体的被装饰者:纯豆浆
 */
public class SoyBeanMilk implements Drink {
    @Override
    public int cost() {
        return 2;
    }

    @Override
    public String desc() {
        return "纯豆浆";
    }
}
