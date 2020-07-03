package observer2;

import java.util.Observable;
import java.util.Observer;

public class User2 implements Observer {
    private String name;
    public User2(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name+",你关注的当前疫情消息更新为："+arg);
    }
}
