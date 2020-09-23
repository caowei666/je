package service;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "Hello Dubbo 8080";
    }
}
