package aop;

public class test {
    public static void main(String[] args) {
        UserServieImpl userServiceImpl = new UserServieImpl();
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(userServiceImpl);  //要代理的对象
        proxyFactoryBean.setAdvice(new LogTimeAdvice()); //设置切面通知
        UserService proxy = (UserService)proxyFactoryBean.getProxy();
        proxy.add("Sunny");
        proxy.add("nini");
        proxy.add("awei");
    }
}
