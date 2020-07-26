package aop;

public class Test {
    public static void main(String[] args) {
//        IActorService target = new ActorServiceImpl();
//        target.play();
        BaseAspect aspect = new ActorAspect();  //切面
        IActorService proxy = ProxyFactory.createProxy(IActorService.class,aspect);
        proxy.rest();
    }
}
