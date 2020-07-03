package observer2;

import java.util.Observable;

public class YiQingMessage2 extends Observable {
    private String message;

    public void setMessage(String message) {
        this.message = message;
        setChanged();  //设置标记，true表示更新，false表示不更新
        notifyObservers(message);
    }
    public String  getMessage(){
        return message;
    }
}
