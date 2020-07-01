package data;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Cache(){};
    private Map<Integer,Order> map = new HashMap<>();
    private volatile static Cache cache;
    public static Cache getInstance(){
        if(cache == null){
            synchronized (Cache.class){
                if(cache == null){
                    cache = new Cache();
                }
            }
        }
        return cache;
    }
    //把订单添加到缓存中
    public void putCache(int key,Order value){
        System.out.println("把订单数据添加到缓存");
        map.put(key,value);
    }
    //从缓存中读取订单
    public Order getCache(int key){
        System.out.println("从缓存中查询订单...");
        return map.get(key);
    }
}
