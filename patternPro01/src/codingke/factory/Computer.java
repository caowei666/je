package codingke.factory;

public class Computer implements Product{
    @Override
    public void work() {
        System.out.println("电脑开始工作");
    }
}
