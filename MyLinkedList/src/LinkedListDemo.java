/**
 *1、链表和数组都属于线性数据结构
 * 2、链表数据结构的特性：适合插入和删除
 * 3、查找元素需要遍历，因此不支持随机查找，并不宜过长，否则会导致性能下降
 * 4、链表可以用于实现栈数据结构，或者队列
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(5);
        list.add(61);
        list.add(62);
        list.add(16);
        list.add(5);
        list.print();  //10->5->61->62->16->5->
        System.out.println("查找");
        System.out.println(list.find(5));  //true
        System.out.println("修改");
        list.updata(5,11);
        list.print();  //10->11->61->62->16->5->
        System.out.println("插入");
        list.insert(2,33);
        list.print();  //10->11->33->61->62->16->5->
        System.out.println("删除");
        list.delete(11);
        list.print();   //10->33->61->62->16->5->
    }
}

//链表
class MyLinkedList{
    private Node rootNode;   //根节点
    private int currentNodeIndex = 0;  //表示节点的序号，从0开始

    //添加(提供给外部使用)
    public void add(int data){
        if(rootNode == null){
            rootNode = new Node(data);
        }else {
            rootNode.addNode(data);
        }
    }
    //删除
    public void delete(int data){
        if(rootNode==null) return;
        if(rootNode.data==data){  //表示删除的是跟节点，把根节点的下一个节点作为根节点
            rootNode = rootNode.next;
        }else {
            rootNode.delNode(data);
        }
    }

    //查找
    public boolean find(int data){
        if(rootNode == null)return false;
        if(rootNode.data == data){
            return true;
        }else {
            return rootNode.findNode(data);
        }
    }

    //修改
    public boolean updata(int oldData,int newData){
        if(rootNode==null)return false;
        if(rootNode.data==oldData){
            rootNode.setData(newData);
            return true;
        }else {
            return rootNode.updateNode(oldData, newData);
        }
    }

    //插入
    public boolean insert(int index,int data){
        if(index < 0) return false;
        currentNodeIndex = 0;
        if(currentNodeIndex==index){  //表示插入的位置在根节点前
            Node newNode = new Node(data);
            newNode.next = rootNode;
            rootNode = newNode;
            return true;
        }else {
            return rootNode.insertNode(index, data);
        }
    }

    //打印
    public void print(){
        if(rootNode != null){
            System.out.print(rootNode.data+"->");  //打印跟节点
            rootNode.printNode();
            System.out.println();
        }
    }
    //内部类(表示链表中的一个节点对象)
    //谁拥有数据，谁就应该提供功能
    private class Node{
        private int data;  //表示链表中存储的数据是整数
        private Node next;  //表示当前节点的下一个节点
        public Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        //添加节点（在链表的最后添加）
        public void addNode(int data){
            if(this.next==null){
                this.next = new Node(data);
            }else {
                this.next.addNode(data);
            }
        }
        //删除节点（删除当前节点的下一个节点）
        public void delNode(int data){
            if(this.next != null){
                if(this.next.data == data){
                    this.next = this.next.next;
                }else {
                    this.next.delNode(data);
                }
            }
        }
        //查找节点是否存在
        public boolean findNode(int data){
            if(this.next != null){
                if(this.next.data == data){
                    return true;
                }else {
                    return this.next.findNode(data);
                }
            }
            return false;
        }
        //更新节点
        public boolean updateNode(int oldData,int newData){
            if(this.next != null){
                if(this.next.data == oldData){
                    this.next.data = newData;
                    return true;
                }else {
                    this.next.updateNode(oldData,newData);
                }
            }
            return false;
        }
        //插入节点(前插)
        public boolean insertNode(int index,int data){
            if(this.next != null){
                currentNodeIndex++;
                if(index == currentNodeIndex){
                    Node newNode = new Node(data);
                    newNode.next = this.next;
                    this.next = newNode;
                    return true;
                }else {
                    return this.next.insertNode(index, data);
                }
            }
            return false;
        }
        //输出所有节点
        public void printNode(){
            if(this.next != null){
                System.out.print(this.next.data+"->");
                //递归调用输出下一个节点
                this.next.printNode();
            }
        }
    }
}
