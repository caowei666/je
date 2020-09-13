import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class ZkTest {
    static ZooKeeper zooKeeper = null;
    public static void main(String[] args) {
        try {
            zooKeeper = new ZooKeeper("www.vm.com:2181", 5000, new Watcher() {
//            zooKeeper = new ZooKeeper("www.vm.com:2281,www.vm.com:2282,www.vm.com:2283", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    Event.EventType type = watchedEvent.getType();
                    if(Event.EventType.None==type){
                        System.out.println("链接成功");
                    }else if(Event.EventType.NodeDeleted == type){
                        System.out.println(watchedEvent.getPath()+"节点被删除");
                    }
                }
            });
//            createNode("/p1","520");
//            Stat exist = exist("/coding123");
//            zooKeeper.delete("/coding123",-1);
            List<String> children = zooKeeper.getChildren("/", null);
            for (String child:children){
                System.out.println(child);
            }
//            zooKeeper.delete("/coding0000000001",-1);
//            Stat stat = exist("/coding");
//            if(stat!=null){
//                System.out.println(stat);
////                String data = getData("/coding");
//                //update("/coding","haha",-1);  //-1代表最新版本
//                update("/coding","haha",stat.getVersion());
//            }else {
//                System.out.println("节点不存在");
//            }
//            System.out.println(stat.getVersion());
//            System.out.println(getData("/coding"));

            zooKeeper.close();   //关闭后临时节点消失
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }
    //创建节点(分为持久节点和临时节点（关闭后节点消失）)（又分为是否带序号）
    //不能有同名节点
    public static boolean createNode(String path,String data){
        try {
            //CreateMode.PERSISTENT永久节点
            //CreateMode.PERSISTENT_SEQUENTIAL永久带序列化的节点
            // CreateMode.EPHEMERAL临时节点
            zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            return true;
        } catch (KeeperException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    //查看节点数据
    public static String getData(String path){
        Stat stat = exist(path);
        try {
            byte[] data = zooKeeper.getData(path, true, stat);
            return new String(data);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    //节点是否存在
    public static Stat exist(String path){
        try {
            return zooKeeper.exists(path,true);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    //更新节点数据
    public static Stat update(String path,String data,int version){
        try {
            return zooKeeper.setData(path, data.getBytes(), version);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
