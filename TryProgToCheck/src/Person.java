public class Person {
    String name;
    float marks;
    float age;
   Person(String name,float marks){
        this.name = name;
        this.marks = marks;
    }

    Person(String name, float age,float marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    Person(){
        System.out.println("hello");
    }

    public static void main(String[] args) {

      Person p1 = new Person();

    }

}
/*
class SwapTest{
    public static void swap(Object x, Object y){
        Object t;
        t=x;
        x=y;
        y=t;
        System.out.println("Person 1 ="+x+" P2 = "+ y);
    }

    public static void main(String[] args) {
        Object p1 = new Person("Gaurav",560);
        Object p2 = new Person("saurav",570);
        System.out.println("Person 1 ="+p1 +" P2 = "+ p2);
        swap(p1,p2);
    }

}
*/
