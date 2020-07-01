package adapter;

public class PowerBImpl implements PowerB {
    @Override
    public void connection() {
        System.out.println("powerB电源插入，开始工作");
    }
}
