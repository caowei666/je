package codingke.factory;

public class Phone implements Product{

    @Override
    public void work() {
        System.out.println("手机开始工作");
    }
}
