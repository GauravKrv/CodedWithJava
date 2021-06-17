public class MyMethods {
    int x = 10;
    void nonStatic1(){
        System.out.println("Inside NS1");
    }
    void nonStatic2(){
        nonStatic1();  //can be directly accessed within the class
        static1();

    }
    static void static1(){
        System.out.println("Inside Static1");

    }


    public static void main(String[] args) {
       // static1();//available without any object
    MyMethods t = new MyMethods();
    t.nonStatic1(); //not available withaut an object
        t.nonStatic2();
        MyMethods.static1();

    }


}
class Test{
    void nonStatic3(){
        MyMethods t = new MyMethods();
        t.nonStatic2();
        t.nonStatic1();
        MyMethods.static1();
        
    }
    static void static2(){
        MyMethods t = new MyMethods();
        t.nonStatic2();
        t.nonStatic1();
        MyMethods.static1();


    }
}
