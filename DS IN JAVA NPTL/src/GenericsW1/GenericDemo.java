package GenericsW1;

public class  GenericDemo {

    public  static void genericPrintswap(Integer x, Integer y){
       Integer t;
       t = x;
       x = y;
       y = t;
    }

    public static void main(String[] args) {

        Integer x = new Integer(21);
       // Integer y = 22;
        Integer y = new Integer(23);
        System.out.println("x = "+x + " y = "+ y);
        genericPrintswap(x,y);
        System.out.println("After swap x = "+x + " y = "+ y);

    }
}

class  GenericDemo2 {

   public  <T> void genericPrint( T x, T y){
       System.out.println(x);
       System.out.println(y);
   }
    public static  <T> void genericPrint( T x, T y,T z){//method overloading example
        System.out.println(x);
        System.out.println(y);
    }

   public static void main(String[] args) {
       GenericDemo2 Gd2 = new GenericDemo2();

       Gd2.genericPrint("Hello",1.5);

   }
}


class PersonGen {
    String name;
    double marks;
    PersonGen(String name, double marks) {
        this.name = name; this.marks = marks;
    }
}

//3.
class SwapTest4{
    public static void swap(Object x, Object y){
        Object t;
        t = x;
        x = y;
        y = t;
    }
    public static void main(String args[]){
        Object p1 = new PersonGen("Sumit", 99.9);
        Double p2 = new Double( 66.6);
        System.out.println("P1 = " + p1 +" y = " + p2);
        swap(p1, p2);
        System.out.println("P1 = " + p1 +" y = " + p2);

}}//Wrong output
