package filter;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    @Override
    public void setFilterChainDefinitions(String definitions) {
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }
        section.put("/menu/**", "roles[admin]");
        this.setFilterChainDefinitionMap(section);
    }
}
