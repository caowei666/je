package com.codingke.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        //用来存放所有的用户线程
        Vector<UserThread> vector = new Vector<>();
        //创建一个能运行三个线程的线程池
        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println("服务器已启动，等待连接......");
            while (true){
                Socket socket = server.accept();  //当有客户端连接成功会返回socket对象
                UserThread user = new UserThread(vector,socket);
                es.execute(user);  //启动线程
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserThread implements Runnable{
    private String name; //客户端的用户名（唯一的）
    private Vector<UserThread> vector;
    private Socket socket;
    private ObjectInputStream ois;  //对象输入流，通过它来读取序列化的对象
    private ObjectOutputStream oos; //对象输出流
    private boolean flag = true;
    public UserThread(Vector<UserThread> vector, Socket socket) {
        this.vector = vector;
        this.socket = socket;
        this.vector.add(this);
    }

    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"已连接");
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            while (flag){
                Message msg = (Message) ois.readObject(); //读取消息包
                int type = msg.getType();
                switch (type){
                    case MessageType.TYPE_LOGIN:
                        name = msg.getFrom();
                        msg.setInfo("欢迎你：");
                        oos.writeObject(msg);
                        break;
                    case  MessageType.TYPE_SEND:
                        String to = msg.getTo();
                        UserThread ut;
                        for (int i = 0; i < vector.size(); i++) {
                            ut = vector.get(i);
                            if(to.equals(ut.name) && ut != this){
                                ut.oos.writeObject(msg);
                                break;
                            }
                        }
                        break;
                }
            }
            ois.close();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            flag = false;
        }
    }
}
