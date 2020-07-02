package decorator;


/**
 * 装饰者的基类（父类）
 * 1、装饰者装饰的是谁？装饰的是饮料（Drink）
 */
public abstract class Decorator implements Drink{
    private Drink drink;
    public Decorator(Drink drink){
        this.drink = drink;
    }
    @Override
    public int cost() {   //计算价格
        return drink.cost();
    }

    @Override
    public String desc() {    //描述
        return drink.desc();
    }
}
