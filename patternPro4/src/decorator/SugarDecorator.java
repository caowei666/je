package decorator;

public class SugarDecorator extends Decorator{
    public SugarDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public int cost() {
        return super.cost()+1;
    }

    @Override
    public String desc() {
        return super.desc()+"+糖";
    }
}
