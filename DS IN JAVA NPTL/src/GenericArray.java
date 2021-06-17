/*
1. You can define a varargs method with an argument an array (of any type).
-- In other words, the values which you want to pass to a method, store them in
an array and then pass the array to the method

2.You cannot instantiate an array whose element type is a type
parameter. That is following is invalid.
T a = new T[5];
The reason is that you can’t create an array of T is that there is no
way for the compiler to know what type of array to actually create







* */



public class GenericArray<T> {
    //dec a gen array
    T  a[];
    //constrctor to load the array
    GenericArray(T x[]){
        a = x;
    }
      void printData(T b[]){  //method to get arr element

        for(int i =0;i<b.length;i++)
            System.out.println(b[i] + " ");
          System.out.println();
     }
     void reverseArray(T b[]){     //method to reverse array elem
         System.out.println("BEFORE REV a[] elem are: ");
         for(int i =0;i<b.length;i++)
             System.out.println(a[i] + " ");
         System.out.println();

         System.out.println("BEFORE REV b[] elem are: ");
         for(int i =0;i<b.length;i++)
             System.out.println(b[i] + " ");
         System.out.println();


         int front  =0;int rear = b.length-1;
          T temp;
          for(int i = 0;i<=rear;i++,rear--){
              temp = b[rear];
              b[rear] = a[i];
              a[i] = temp;

          }
         System.out.println("a[] elem are: ");

         for(int i =0;i<b.length;i++)
             System.out.println(a[i] + " ");
         System.out.println();
         System.out.println("b[] elem are: ");

         for(int i =0;i<b.length;i++)
             System.out.println(b[i] + " ");
         System.out.println();

     }

    public static void main(String[] args) {
        Integer x[] = {1,2,3,4,5};
        GenericArray<Integer> aInt = new GenericArray<>(x);
        //store dataa into generic array
        aInt.printData(x);
        aInt.reverseArray(x);
        aInt.printData(x); //print the reversed array :
        // as we see referenced is passed here


    }
}
//2.Varargs method using arrays
class VarargsMethodDemo1 {
    static void varargsMethod1(int v[]) {
        System.out.print("Number of args: " + v.length +" Elements: ");
        for(int x : v)
            System.out.print(x + " ");
        System.out.println();
    }
    public static void main(String args[]) {
// Following arrays are created for test...
        int x[] = { 1, 3, 5, 7 };
        int y[] = { 2, 4};
        int z[] = { };
        varargsMethod1 (x); // Passed 4 values to the method
        varargsMethod1 (y); // Passed 2 values to the method
        varargsMethod1 (z); // Passed no argument to the method
    }
}

//3.Varargs using elipsis
class VarargsMethodDemo2 {
    //Defining a varargs method using ellipsis
    static void varargsMethod2(int ...v) {
        System.out.println("Number of arguments: " + v.length);
        for (int i: v) // For each item i in array v
            System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String args[]) {
// Calling the varargs method with variable arguments
        varargsMethod2 (9); // One parameter
        varargsMethod2 (1, -2, 3, -4); // Four parameters
        varargsMethod2 (); // no parameter
    }
}

//4.Varargs using Objects
/*
1. This is the most elegant approach to implement the varargs method in a Java
program.
2. It uses the ellipsis and in addition to this, it uses the Object type.
3. For example, to define a varargs method using Object, your method declaration
should take the following form.
public static void methodName(Object...obj) {
//Body of the method
}
Note:
• The restriction that the method can have zero or more parameters preceding this, but
this must be the last.

* */
class VarargsMethodDemo3 {
   // public static void varargsMethod3(Object ... obj,int a) {-->Will show error as obj is not last param
   public static void varargsMethod3(int a,Object ... obj) {
    for(Object o : obj)
            System.out.print(" " + o);
        System.out.println( );
       System.out.print(" " + a);
    }

    public static void main(String[] args) {
        varargsMethod3( 1, "String", 2.3, true); // Four arguments
        varargsMethod3 (1); // No arguments for obj
        varargsMethod3 (15, 25, 35, 45, 55); // Five arguments
    }
}
