import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroTest {
    public static void main(String[] args) {
        //1.导入配置文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_mysql.ini");
        //2.解析配置文件，并返回securityManager实例
        SecurityManager securityManager = factory.getInstance();
        //3.将SecurityManager绑定给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //4.拿到当前登录对象
        Subject subject = SecurityUtils.getSubject();
        //当前对象是否被授权
        System.out.println("当前用户是否授权:"+subject.isAuthenticated()); //false
        UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");
        try {
            //登录
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        } catch (UnknownAccountException e){
            System.out.println("用户名不存在");
        }
        //用户是否登录
        System.out.println("用户是否登录："+subject.isAuthenticated()); //true
        System.out.println("用户是否有admin角色："+subject.hasRole("admin")); //true
        System.out.println("用户是否有guest角色："+subject.hasRole("guest"));  //false
        //是否有某菜单权限
        System.out.println("index.html:"+subject.isPermitted("index.html"));
        subject.logout();
        System.out.println("用户是否登录："+subject.isAuthenticated()); //false
    }
}
