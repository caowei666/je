package adapter;

public class PowerAImpl implements PowerA{
    @Override
    public void insert() {
        System.out.println("A电源接口插入，开始工作");
    }
}
