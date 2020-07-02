package decorator;

public class BlackBeanDecorator extends Decorator {
    public BlackBeanDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public int cost() {
        return super.cost()+1;
    }

    @Override
    public String desc() {
        return super.desc()+"+黑豆";
    }
}
