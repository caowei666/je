package decorator;

public class Test {
    public static void main(String[] args) {
        Drink drink = new SoyBeanMilk();
        Drink egg = new EggDecorator(drink);
        Drink sugar = new SugarDecorator(egg);
        Drink Black = new BlackBeanDecorator(sugar);
        System.out.println("你一共花了："+Black.cost());
        System.out.println("内容包含："+Black.desc());
    }
}
