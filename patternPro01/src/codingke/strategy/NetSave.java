package codingke.strategy;

public class NetSave implements ISave {
    @Override
    public void save(String data){
        System.out.println("把数据"+data+"保持到网络中。");
    }
}
