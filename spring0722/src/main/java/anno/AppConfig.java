package anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //相当于xml配置文件
public class AppConfig {
    @Bean()
    public Bird bird1(){
        return new Bird();
    }
    @Bean
    public Bird bird2(){
        return new Bird();
    }
}
