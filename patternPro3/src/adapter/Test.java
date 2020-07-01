package adapter;

public class Test {
    public static void main(String[] args) {
        PowerA powerA = new PowerAImpl();
        work(powerA);

        PowerB powerB = new PowerBImpl();
        Adapter adapter = new Adapter(powerB);
        work(adapter);

        System.out.println("----------");
        PowerC powerC = new PowerCImpl();
        Adapter adapter1 = new Adapter(powerC);
        work(adapter1);
    }

    //
    public static void work(PowerA powerA){
        System.out.println("work start");
        powerA.insert();
        System.out.println("work end");
    }
}
