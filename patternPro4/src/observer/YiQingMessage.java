package observer;

import java.util.ArrayList;
import java.util.List;
//发布者，被观察者，发布消息
public class YiQingMessage implements YiQingMessageSubject{
    //维护所有的观察者列表
    private List<Observer> list = new ArrayList<>();

    private String message;  //疫情信息

    //更新消息的方法
    public void setMessage(String message){
        this.message = message;
        notifyObservers();  //通知所有的观察者
    }
    @Override
    public void addObserver(Observer observer) {
        list.add(observer);  //添加一个观察者（把一个用户注册成一个观察者）
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);  //从观察者列表中删除
    }

    @Override
    public void notifyObservers() {
        //通知所有的观察者对象更新信息
        for(Observer o:list){
            o.update(message);
        }
    }
}
