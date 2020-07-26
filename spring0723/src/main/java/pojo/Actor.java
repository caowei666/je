package pojo;

public class Actor {
    public void play(){
        System.out.println("表演");
    }
    public void play(String name) throws Exception{
        System.out.println("表演"+name);
        throw new Exception("手动异常");
    }
}
