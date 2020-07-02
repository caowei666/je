package decorator;


//被装饰者的接口
//饮料：豆浆、咖啡...
public interface Drink {
    public int cost();   //计算价格
    public String desc();  //描述
}
