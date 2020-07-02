package decorator;

public class EggDecorator extends Decorator {

    public EggDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public int cost() {
        return super.cost()+1;
    }

    @Override
    public String desc() {
        return super.desc()+"+鸡蛋";
    }
}
