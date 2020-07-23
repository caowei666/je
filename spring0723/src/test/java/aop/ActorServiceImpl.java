package aop;

public class ActorServiceImpl implements IActorService {
    @Override
    public void play() {
        System.out.println("我在表演");
    }
}
