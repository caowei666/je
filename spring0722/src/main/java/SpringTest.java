import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Cat;
import pojo.Dog;
import pojo.Master;
import pojo.Pet;

public class SpringTest {
    public static void main(String[] args) {
//        Master master = new Master();
//        master.sayHello();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-test.xml");
        Master master = (Master)applicationContext.getBean("master");  //通过id获取
//        Master master = applicationContext.getBean(Master.class);  //通过类名获取，必须在xml里面唯一定义才行
//        master.sayHello();
        System.out.println(master.getName());
        System.out.println(master.getAge());
        master.getPet().shout();
        for(String s:master.getStringList()){
            System.out.println(s);
        }
        for (String s:master.getStringSet()){
            System.out.println(s);
        }
        System.out.println(master.getMap().get("a"));


        Master master2 = (Master)applicationContext.getBean("master2");  //通过id获取
        System.out.println(master2.getName());
        System.out.println(master2.getAge());
        master2.getPet().shout();

        Master master3 = (Master)applicationContext.getBean("master3");  //通过id获取
        System.out.println(master3.getName());
        System.out.println(master3.getAge());
        master3.getPet().shout();

        //强耦合:改了需求需要改业务代码
        //控制反转和依赖注入的目的：解耦
//        Pet pet = new Dog();
//        Pet pet = new Cat();
        Pet pet = (Pet)applicationContext.getBean("pet");
        pet.shout();

        Pet pet2 = (Pet)applicationContext.getBean("pet2");
        pet2.shout();

        Pet pet3 = (Pet)applicationContext.getBean("pet3");
        pet3.shout();
    }
}
