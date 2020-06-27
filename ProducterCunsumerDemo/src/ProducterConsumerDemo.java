/**
 * 多线程共享数据时线程不安全的问题；
 *
 */
public class ProducterConsumerDemo {
    public static void main(String[] args) {
        Food food = new Food();
        Producter p = new Producter(food);
        Consumer c = new Consumer(food);
        Thread tp = new Thread(p);
        Thread cp = new Thread(c);
        tp.start();
        cp.start();
    }
}

//生产者
class Producter implements Runnable{
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                food.set("韭菜炒鸡蛋","程序员最爱，补啊！",50f);
            }else {
                food.set("凉拌肾宝","专治肾亏",100f);
            }
        }
    }
}

//消费者
class Consumer implements Runnable{
    private Food food;

    public Consumer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}

//食物（两个线程需要共享的数据对象）
class Food{
    private String name;  //菜名
    private String description;  //菜的功效
    private float price; //价格
    private boolean flag = true;  //true表示可以生产食物 false表示可以消费

    public Food() {
    }

    public Food(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //生产食物
    //同步：对象锁，以当前对象上标记一个锁
    public synchronized void set(String name, String description, float price){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDescription(description);
        this.setPrice(price);
        flag = false;
        this.notify();
    }

    //消费食物
    public synchronized void get(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"-"+this.getDescription()+"-"+this.getPrice());
        flag = true;
        this.notify();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
