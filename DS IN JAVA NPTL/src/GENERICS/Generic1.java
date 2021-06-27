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