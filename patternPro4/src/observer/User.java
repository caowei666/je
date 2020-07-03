package observer;

/**
 * 具体的观察者
 */
public class User implements Observer {
    private String name;
    public User(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name+",你关注的当前疫情消息更新为："+message);
    }
}
