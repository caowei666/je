package codingke.strategy;

public class DBSave implements ISave {
    @Override
    public void save(String data){
        System.out.println("把数据"+data+"保持到数据库中。");
    }
}
