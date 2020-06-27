import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 数组和链表 都是存储一个对象
 * HashMap 存储数据是以一对数据来存储，键值对（key(对象)->value(对象)）
 * HashMsp 是一种数据结构
 * JDK1.8之前 实现 数组+链表 数组的默认大小是16
 * DEFAULT_LOAD_FACTOR加载因子:0.75f(表示容量达到75%，那么数组就会重写扩充)
 * JDK1.8及之后 实现 数组+链表+二叉树（红黑树）
 * 数组的最大容量是整数最大值的一半
 * 使用位移来表示整数（计算效率高）
 *
 * 链表与二叉树的转换条件： 键值对的总数大于64时
 * 1、在扩容时，在哈希表中数组同一个位置的链表长度大于8时（阀值），那么链表转换成红黑树，来提高查询效率
 * 2、在扩容时，当哈希表中数组同一个位置的链表长度小于6时（阀值），那么红黑树转换成链表。来提高查询效率
 *阀值为什么是8和6？（防抖）
 *
 * 什么是哈希表？
 * 这个是因为存储数据的方式被称为哈希算法
 * Object类中hashCode方法是一个本地方法：表示此方法的具体实现是由C、C++来实现的
 * 同一个对象，我们要保证hashCode值是相同的，如果不同那么此对象的哈希表中会有问题？（内存泄漏）
 * 什么问题？
 * 面试题：JAVA有没有内存泄漏问题？
 * 什么叫内存泄漏？由于对象在运行过程中hashCode不同，导致该对象在哈希表中无法找到
 * 哈希表存储数据的算法：
 * 通过计算key对象的hashCode值，来确定key对象在哈希表数组中的存储位置，目的是提高查找效率
 * 同一个对象，hashCode值相同，不同的对象，hashCode可能相同
 * 使用hashCode计算对象的hash值
 *
 * 怎么扩容？初始化大小？
 * 1、在第一次put数据的适合初始化大小
 * 2、在put方法中实现，扩容算法是乘2
 * 3、每次扩容哈希表，会导致所有已存储的数据重新计算哈希值，存储到新的哈希表中（重新散列）
 *      所以hashMap中，对象所在的位置不保证永远不变
 *      重新散列会导致重新计算所有对象，消耗性能
 *      在可预知的情况下，散列次数越少越好（可以给初始容量大小）
 *
 *      优点：取值快，数据量越大越明显
 *      缺点: 线程不安全，避免频繁散列（rehash）
 *
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        //以键值对的方式存储数据
        hashMap.put(1,"boy");
        hashMap.put(2,"xiaoxu");
        hashMap.put(3,"lingsong");
        hashMap.put(4,"chuanshuo");
        //已知key,取value
        String s = hashMap.get(1);
        System.out.println(s);

        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            String value = hashMap.get(key);
            System.out.println(key+"->"+value);
        }

        Object o = new Object();
        int i = o.hashCode();
        System.out.println(i);

        HashSet<User> users = new HashSet<>();
        User u1 = new User(1,22,"boy");
        users.add(u1);
        System.out.println(users.size()+"----"+u1.hashCode()); //1----129174
        u1.setAge(18);
        users.remove(u1);
        System.out.println(users.size()+"-----"+u1.hashCode()); //1-----129050
    }
}
