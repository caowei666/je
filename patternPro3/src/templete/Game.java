package templete;

public abstract class Game {
    //模板方法
    public void play(){
        initialize();
        startPlay();
        endPlay();
    }

    public abstract void initialize(); //初始化
    public abstract void startPlay();
    public abstract void endPlay();
}
