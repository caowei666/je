public class jieChengDemo {
    public static void main(String[] args) {
        System.out.println(jiecheng1(5));
    }

    //请一个数的阶乘（5  1*2*3*4*5）
    public static int jiecheng1(int num){
        if(num==1 ||num==0){
            return num;
        }
        return jiecheng1(num - 1)*num;
    }
}

