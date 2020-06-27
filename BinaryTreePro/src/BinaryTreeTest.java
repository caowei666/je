public class BinaryTreeTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(8);
        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.print();
    }
}

//自定义二叉树结构
class BinarySearchTree{
    private Node rootNode; //根节点

    public void add(int data){
        if(rootNode==null){
            rootNode = new Node(data);
        }else {
            rootNode.addNode(data);
        }
    }

    public void print(){
        rootNode.printNode();
    }
    //节点类
    private class Node{
        private int data;  //节点上存储的数据
        private Node left;  //左节点
        private Node right;   //右节点
        public Node(int data){
            this.data = data;
        }
        //添加节点(小于当前节点放左边，大于等于当前节点放右边)
        private void addNode(int data){
            if(data < this.data){  //放左边
                if(this.left == null){
                    this.left = new Node(data);
                }else {
                    this.left.addNode(data);
                }
            }else {
                if(this.right == null){
                    this.right = new Node(data);
                }else {
                    this.right.addNode(data);
                }
            }
        }
        //中序遍历、先序遍历(根左右)、后序遍历（作用根）
        private void printNode(){
            //输出左边
            if(this.left!=null){
                this.left.printNode();
            }
            //输出中间
            System.out.print(this.data+",");
            //输出右边
            if(this.right!=null){
                this.right.printNode();
            }
        }
    }
}
