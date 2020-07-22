package pojo;

public class PetShop {
    public static Dog getDog(){
        return new Dog();
    }

    public static Cat getCat(){
        return new Cat();
    }

    public static Pet getPet (String name){
        if("cat".equals(name)){
            return new Cat();
        }else {
            return new Dog();
        }
    }
}
