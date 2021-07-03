package GENERICS;

import java.util.Scanner;

public class Generic1<T> {
    Scanner sc = new Scanner(System.in);
      void createGenericArray(T x[],int size){
        for (int i=0; i<size; i++){
            //x[i] = sc.n
        }
    }
}
class Generic2{
    //WORKS
   <S> void genericPrint(S t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        Generic2 g = new Generic2();
        g.genericPrint(101);
        g.genericPrint("Hello");
        g.genericPrint(3.1444);
    }
}

class Generic3Static{
    //WORKS
   static <S> void genericPrint(S s){
       System.out.println(s.getClass().getName() + " : "+ s);
    }

    public static void main(String[] args) {
        genericPrint(101);
        genericPrint("Hello");
        genericPrint(3.1444);
    }
    /*O/P
java.lang.Integer : 101
java.lang.String : Hello
java.lang.Double : 3.1444
    * */
}

class Generic4Swap{
    //NOT WORKS
    public static <S> void swap(S x, S y){
        S temp;
        temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        Integer x = new Integer(10);
        Integer y = new Integer(190);
        System.out.println("X = "+x+" Y = "+ y);
        swap(x,y);
        System.out.println("X = "+x+" Y = "+ y);
    }
}

class Generic5VarArgs{
    //WORKS - Ellipsis(...) =  an array
    @SafeVarargs
    static <T> void varNumberofArgumentsGeneric(T ...v){
        System.out.println("Number of args = "+ v.length);
        for (int i=0; i<v.length;i++){
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    static <T> void varNumberofArgumentsObject(T ...v){
        System.out.println("Number of args = "+ v.length);
        for (int i=0; i<v.length;i++){
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        varNumberofArgumentsGeneric(3);
        varNumberofArgumentsGeneric(-1,-3,-5,0,22);
        varNumberofArgumentsGeneric("hello",-2,3,"Wow");
        varNumberofArgumentsObject("hello",-2,3,"Wow");
    }
/*O/P 1
Number of args = 5
-1 -3 -5 0 22
Number of args = 4
hello -2 3 Wow
* */
}

/*
The syntax for declaring a generic class is as follows:
[<<Access] class <ClassName><<Type1> [, <Type2>, …]> {
… body of the class
}
Here, is the full syntax for declaring a reference to a generic class and
instance creation:
<className><typeList> varName = new <className><typeList> (<InputArray>);
* */
class Generic6Class <G>{
    //WORKS ... Cannot(use static functions) refer a function which prints generic array with Class objects
   //A generic method or any method in a generic class can be declared as zstatic.
    private G x;
    private G[] arr;
    //Constructor
    public Generic6Class(G g){
        x = g;
    }
    public Generic6Class(G[] a){
       arr = a;
    }

    public void printData(){
        System.out.println(x);
    }

      static <G> void printGenericArray(G A[]){
        for (int i = 0;  i<A.length;i ++) {
            System.out.print(A[i]+" ");
        }
    }

    public static void main(String[] args) {
        Generic6Class<String> g1 = new Generic6Class<>("ghello");
        Generic6Class<Integer> g2 = new Generic6Class<>(21);
        g1.printData();
        g2.printData();
        Integer[] ar = {1,2,3,4,5};
/*You cannot instantiate an array whose element type is a type
parameter. That is following is invalid.
T a = new T[5];
The reason is that you can’t create an array of T is that there is no way for the compiler to know what type of array to actually creat*/
       printGenericArray(ar);
    }
}





















