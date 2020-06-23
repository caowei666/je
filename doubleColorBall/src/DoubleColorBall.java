import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 1、准备一些变量
 * 2、用户选择是机选还是手选号码
 * 3、接收用户选号（6红1蓝）
 * 4、生成系统号码和用户号码，记录个数
 * 5、验证中奖号码
 * 6、系统号码排序
 * 7、公布结果
 */
public class DoubleColorBall {
    public static void main(String[] args) {
        //定义变量
        int[] userRedBall = new int[6];
        int[] sysRedBall = new int[6];
        int userBlueBall = 0;
        int sysBlueBall = 0;
        int redCount = 0;
        int blueCount = 0;

        int[] redBall = new int[33];  //用于记录
        for (int i = 0; i < redBall.length; i++) {
            redBall[i] = i+1;
        }
        //游戏开始，系统提示
        System.out.println("双色球游戏开始！good luck");
        System.out.println("请问您是机选还是手选号码（1、机选，2、手选）");

        Scanner input = new Scanner(System.in);
        Random random = new Random(); //产生随机数

        boolean flag = true;
        while (flag){
            switch (input.nextInt()){
                case 1:  //机选
                    computerSelection(redBall,userRedBall);  //计算红球
                    userBlueBall = random.nextInt(16)+1;  //机选蓝球
                    flag = false;
                    break;
                case 2:  //手选
                    System.out.println("请选择6个红球号码（1-33）");
                    for (int i = 0; i < userRedBall.length; i++) {
                        userRedBall[i] = input.nextInt();
                    }
                    System.out.println("请选择6个篮球号码（1-16）");
                    userBlueBall = input.nextInt();
                    flag = false;
                    break;
                default:
                    System.out.println("请问您是机选还是手选号码（1、机选，2、手选）");
                    break;
            }
        }

        //生成系统的红球
        computerSelection(redBall,sysRedBall);
        //生成系统的篮球
        sysBlueBall = random.nextInt(16)+1;

        //统计红球结果
        for (int i = 0; i < userRedBall.length; i++) {
            for (int j = 0; j < sysRedBall.length-redCount; j++) {
                if(userRedBall[i] == sysRedBall[j]){
                    int temp = sysRedBall[j];
                    sysRedBall[j]=sysRedBall[sysRedBall.length-1-redCount];
                    redCount++;
                    break;
                }
            }
        }
        if(userBlueBall==sysBlueBall){
            blueCount = 1;
        }

        //验证是否中奖
        if(blueCount == 0 && redCount<=3){
            System.out.println("谢谢惠顾");
        }else if(blueCount==1 && redCount < 3){
            System.out.println("中了6等奖，5块钱");
        }else if((blueCount == 1 && redCount==3) || (blueCount==0 && redCount==4)){
            System.out.println("中了5等奖，10块钱");
        }else if((blueCount == 1 && redCount==4) || (blueCount==0 && redCount==5)){
            System.out.println("中了4等奖，200块钱");
        }else if(blueCount == 1 && redCount==5){
            System.out.println("中了3等奖，3000块钱");
        }else if(blueCount == 0 && redCount==6){
            System.out.println("中了2等奖，150000块钱");
        }else if(blueCount == 1 && redCount==6){
            System.out.println("中了1等奖，5000000块钱");
        }else{
            System.out.println("发生错误");
        }
        //公布系统号码
        System.out.println(Arrays.toString(sysRedBall)+sysBlueBall);
        //用户号码
        System.out.println(Arrays.toString(userRedBall)+userBlueBall);
    }

    //用于在一组数组中随机生成多个不重复数的算法（自动选红球）
    //每选一个吧这个被选的和最后的交换下次被选的总数-1
    private static void computerSelection(int[] redBall, int[] userRedBall) {
        Random r = new Random();
        int index = -1;  //作为随机生成的下标值
        for(int i = 0;i<userRedBall.length;i++){
            index = r.nextInt(redBall.length - i);   //0-33(取不到33)
            userRedBall[i] = redBall[index];
            int temp = redBall[index];
            redBall[index] = redBall[redBall.length-i-1];
            redBall[redBall.length-i-1] = temp;
        }
    }
}
