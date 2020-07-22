package anno;

import org.springframework.stereotype.Component;

//@Component("bird")  //相当于在配置文件里面创建了一个bean,id是bird
public class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
