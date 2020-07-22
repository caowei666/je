package pojo;

public class PetShopBean {
    public Dog getDog(){
        return new Dog();
    }

    public Cat getCat(){
        return new Cat();
    }

    public Pet getPet (String name){
        if("cat".equals(name)){
            return new Cat();
        }else {
            return new Dog();
        }
    }
}
