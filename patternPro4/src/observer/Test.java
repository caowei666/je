package observer;

import observer2.User2;
import observer2.YiQingMessage2;

public class Test {
    public static void main(String[] args) {
        User u1 = new User("boy");
        User u2 = new User("xiaoxu");
        User u3 = new User("awei");
        /**YiQingMessage yiQingMessage = new YiQingMessage();
        yiQingMessage.addObserver(u1);
        yiQingMessage.addObserver(u2);
        yiQingMessage.addObserver(u3);
        yiQingMessage.setMessage("感染了50人呢");
         */
        YiQingMessage2 yiQingMessage2 = new YiQingMessage2();
        yiQingMessage2.addObserver(new User2("bb"));
        yiQingMessage2.addObserver(new User2("aa"));
        yiQingMessage2.setMessage("感染100人了");
    }
}
