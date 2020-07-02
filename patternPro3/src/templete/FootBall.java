package templete;

public class FootBall extends Game{
    @Override
    public void initialize() {
        System.out.println("初始化排球");
    }

    @Override
    public void startPlay() {
        System.out.println("开始打排球");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endPlay() {
        System.out.println("结束打排球");
    }
}
