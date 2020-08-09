package cache;

import com.google.common.cache.CacheBuilder;
import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

public class MyGuavaCache implements Cache {
    private String id;

    private com.google.common.cache.Cache cache = CacheBuilder.newBuilder().build();

    public MyGuavaCache(String id){
        this.id = id;
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        cache.put(o,o1);
    }

    @Override
    public Object getObject(Object o) {
        System.out.println("我是自定义的缓存，你现在查询的是:"+o);
        return cache.getIfPresent(o);
    }

    @Override
    public Object removeObject(Object o) {
        Object obj = this.getObject(o);
        this.cache.invalidate(o);
        return obj;
    }

    @Override
    public void clear() {
        cache.cleanUp();
    }

    @Override
    public int getSize() {
        return (int)cache.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
