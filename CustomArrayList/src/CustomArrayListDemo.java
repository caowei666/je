public class CustomArrayListDemo {
    public static void main(String[] args) {

    }
}

class Duck{
    private int id;
    private int age;
    private String weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void print(){
        System.out.println("id="+id+",age="+age+",weight="+weight);
    }
}
