package com.qianfeng.test;

import com.google.gson.Gson;
import com.test.redis.entity.User;
import org.junit.Test;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Map;

public class TestJedis {
    @Test
    public void testSet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        System.out.println(jedis);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        jedis.set("name","曹伟");
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void testGet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        String name = jedis.get("name");
        System.out.println(name);
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void testDel(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        Long name = jedis.del("name");
        System.out.println(name);
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void testHSet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        jedis.hset("Stu","name","caowei");
        jedis.hset("Stu","age","18");
        jedis.hset("Stu","sex","男");
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void testHGet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        Map<String, String> stu = jedis.hgetAll("Stu");
        System.out.println(stu);
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void testHDel(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        Long hdel = jedis.hdel("Stu", "name");
        System.out.println(hdel);
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void testByteSet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        System.out.println(jedis);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        String key = "user";
        User user = new User(1,"张三",new Date());
        byte[] keyByte = SerializationUtils.serialize(key);
        byte[] userByte = SerializationUtils.serialize(user);
        jedis.set(keyByte,userByte);
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void testByteGet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        System.out.println(jedis);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        String key = "user";
        byte[] keyByte = SerializationUtils.serialize(key);
        byte[] bytes = jedis.get(keyByte);
        User deserialize = (User)SerializationUtils.deserialize(bytes);
        System.out.println(deserialize);
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void testJsonSet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        System.out.println(jedis);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        String key = "user";
        User user = new User(2,"张三",new Date());
        String s = new Gson().toJson(user);
        jedis.set(key, s);
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void testJsonGet(){
        //1.连接redis数据库
        Jedis jedis = new Jedis("192.168.0.162", 6379);
        System.out.println(jedis);
        //如果有密码需要登录
        //jedis.auth("123");
        //2.使用redis命令操作
        String key = "user";
        String s1 = jedis.get(key);
        User user = new Gson().fromJson(s1, User.class);
        System.out.println(user);
        //3.关闭连接
        jedis.close();
    }
}
