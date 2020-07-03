package observer;

/**
 * 观察者的接口（所有观察者都要实现的接口）
 */
public interface Observer {
    //观察者需要更新的信息方法
    public void update(String message);
}
