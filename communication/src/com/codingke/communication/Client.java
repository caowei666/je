package com.codingke.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            Socket socket = new Socket("localhost", 9000);
            System.out.println("服务器连接成功");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //向服务器发送登录信息
            System.out.println("请输入名称：");
            String name = input.nextLine();
            Message msg = new Message(name, "", MessageType.TYPE_LOGIN, null);
            oos.writeObject(msg);
            msg = (Message) ois.readObject();
            System.out.println(msg.getInfo() + msg.getFrom());
            //启动读取消息的线程，不断结束别的客户端发来的消息
            es.execute(new ReadInfoThread(ois));
            //使用主线程来实现发送消息
            boolean flag = true;
            while (flag) {
                msg = new Message();
                System.out.println("To:");
                msg.setTo(input.nextLine());
                msg.setFrom(name);
                msg.setType(MessageType.TYPE_SEND);
                System.out.println("Info:");
                msg.setInfo(input.nextLine());
                oos.writeObject(msg);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//读取消息线程
class ReadInfoThread implements Runnable {
    private ObjectInputStream in;
    private boolean flag = true;

    public ReadInfoThread(ObjectInputStream in) {
        this.in = in;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            while (flag) {
                Message message = (Message) in.readObject();
                System.out.println("[" + message.getFrom() + "]对我说" + message.getInfo());
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


