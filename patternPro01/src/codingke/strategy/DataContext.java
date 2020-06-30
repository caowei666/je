package codingke.strategy;

import java.io.IOException;
import java.util.Properties;

public class DataContext {
    //DataContext只依赖接口，不依赖具体实现，这样的写法就是面向接口编程
    private ISave iSave;

    public static ISave getSave() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("codingke/strategy/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String className = properties.getProperty("context.save");
        ISave iSave = (ISave)Class.forName(className).newInstance();
        return iSave;
    }

    public DataContext(ISave iSave){
        this.iSave = iSave;
    }

    public void save(String data){
        iSave.save(data);
    }
}
