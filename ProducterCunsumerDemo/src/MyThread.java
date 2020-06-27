public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(100);  //让当前线程进入休眠状态，让出CPU时间片，不释放对象监视器
            this.wait();//当前线程进入等待状态，让出CPU时间片，释放对象监视器
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
