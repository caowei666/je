package codingke.strategy;

public class FileSave implements ISave{
    @Override
    public void save(String data){
        System.out.println("把数据"+data+"保持到文件中。");
    }
}
