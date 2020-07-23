package jdk;

import cglib.CglibProxy;

public class Test {
    public static void main(String[] args) {
//        JdkProxy actor = new JdkProxy();
//        ActionInterface movieActor = (ActionInterface)actor.getProxyInstance();
//        movieActor.play();

        CglibProxy cglibProxy = new CglibProxy();
        cglib.MovieActor proxyInstane = (cglib.MovieActor)cglibProxy.getProxyInstane();
        proxyInstane.play();
    }
}
