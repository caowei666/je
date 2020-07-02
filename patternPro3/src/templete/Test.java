package templete;

public class Test {
    public static void main(String[] args) {
        OrderService os = new OrderService();
        os.action("admin","add");
        ProductService ps = new ProductService();
        ps.action("admin","add");

        System.out.println("-------------------");
        FootBall footBall = new FootBall();
        footBall.play();
    }
}
