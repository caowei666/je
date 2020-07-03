package observer;

public interface YiQingMessageSubject {
    public void addObserver(Observer observers);  //添加一个观察者
    public void removeObserver(Observer observer);  //删除一个观察者
    public void notifyObservers();  //通知所有观察者
}
