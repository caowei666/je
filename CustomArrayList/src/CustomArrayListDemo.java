import java.util.Arrays;

/**
 * 1、动态数组变相解决了数组长度固定的问题
 * 2、数组是存储效率最高的数据结构
 * 3、动态数组如果频繁扩充必然带来性能的下降，产生垃圾数组对象
 * 4、数组不适合删除插入等操作，适合添加，查找，遍历
 * 5、动态数组的实现原来被使用在ArrayList、Vector的集合类中
 */
public class CustomArrayListDemo {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(5);
        list.add(new Duck(1,3,"10斤"));
        list.add(new Duck(2,4,"8斤"));
        list.add(new Duck(3,5,"6斤"));
        list.add(new Duck(4,6,"7斤"));
        list.add(new Duck(5,2,"5斤"));
        System.out.println(list.size()); //5
        System.out.println(list.length());  //5
        list.add(new Duck(6,7,"9斤"));
        System.out.println(list.size());  //6
        System.out.println(list.length());  //8
        System.out.println("删除测试");
        list.remove(2);
        list.remove(3);
        System.out.println(list.size());  //4
        System.out.println(list.length());  //8
        System.out.println("更新测试");
        list.update(new Duck(1,2,"1斤"));
        list.printAll();
    }
}

class MyArrayList{
    private Duck[] ducks = null;  //需要管理的对象数组
    private int count = 0;   //对象数组中已存在的数组的个数
    public MyArrayList(int size){
        if(size>0){
            ducks = new Duck[size];
        }else {
            ducks = new Duck[10];
        }
    }
    public int length(){
        return ducks.length;
    }
    public int size(){
        return count;
    }
    //添加元素
    public void add(Duck duck){
        if(count>=ducks.length){  //表示数组已满
            //扩容算法 1、扩容二分之一  2、翻倍
            int newLen = ducks.length*3/2+1;  //求出新数组的长度
            ducks = Arrays.copyOf(ducks,newLen);  //参数：原数组，新数组长度
        }
        //添加元素
        ducks[count] = duck;
        count++;
    }
    //删除元素
    //先查到要删除的元素
    //删除元素，并移动元素的位置
    public void remove(int id){
        for(int i=0;i<count;i++){
            if(ducks[i].getId()==id){  //找到了要删除的元素
                for (int j = i; j < count - 1; j++) {
                    ducks[j] = ducks[j+1];
                }
                ducks[count-1]=null;//把最后一个值设为空
                count--;
                break;
            }
        }
    }
    //更新元素
    public void update(Duck duck){
        for (int i = 0; i < count; i++) {
            if(duck.getId()==ducks[i].getId()){
                ducks[i].setAge(duck.getAge());
                ducks[i].setWeight(duck.getWeight());
                break;
            }
        }
    }
    //输出所有元素
    public void printAll(){
        for (int i = 0; i < count; i++) {
            ducks[i].print();
        }
    }
}

class Duck{
    private int id;
    private int age;
    private String weight;

    public Duck() {
    }

    public Duck(int id, int age, String weight) {
        this.id = id;
        this.age = age;
        this.weight = weight;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void print(){
        System.out.println("id="+id+",age="+age+",weight="+weight);
    }
}
