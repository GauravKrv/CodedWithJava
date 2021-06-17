import java.lang.reflect.Array;
import java.util.Scanner;

public class ArraysW3L2 {
    public static void main(String[] args) {
        int arr[];//dec of 1D arr
        float[] arr2;//dec for second type
        //To allocate memory for arr and declare its size:
        arr = new int[20];
        //Sc To allocate memory for arr and declare its size:in one single line
        int arrSc3[] = new int [6];
        int ar[];
        Array.set(arrSc3,0,22);//ar[] = {1,2,3,4};
        //arrSc3 = {1,2,3,4,5,5};
        //Sc To allocate memory for arr and declare its size and initialise :in one single line

        int[] arrSc2 = {1,2,3,4};//-->RIGHT
        int arrSc4[] = {1,2,3,4};//-->RIGHT
        System.out.println(arrSc3[0]);



    }
}

class ArraysMultiDim{

        public static void main(String[] args) {
       int TwoDArr[][];
       TwoDArr = new int [3][4];
      // int TwoDArr2 [2] [3] = {1,2,3,4,5,6};--->WRONG
          //  TwoDArr = {1,2,3,4,5,6};---->WRONG
         //   int TwoDArr3[2][3] = {1,2,3,4,5,6};--->WRONG
            int[][] TwoDArr2 = {{1,2} , {3,4},{4,5}};//=-->RIGHT

            System.out.println(TwoDArr.length);
            //camps drive things


        }
    }

    class VarLengthArray {
        //WE Can crreate a variable length multidimentional array i.e: 1stR=2cols, 2ndR= 3cols..
        public static void main(String[] args) {
            int x[][] = new int[3][];
            x[0] = new int[3];
            x[1] = new int[2];
            x[2] = new int[4];


        }
    }
class VarArray {
    int[][] TwoDArr2 = {{1,2} , {3,4},{4,5}};//=-->RIG
    float arrSc3[] = new float[6];
    Object[] objects = {TwoDArr2,arrSc3};//any type of elem can be storred n the array if we stored it in
    //object type of array.
}

class ArrInitialKey{
    int[] a = new int[100];
    int size;
    void loadArray(){
        Scanner in = new Scanner(System.in);
        System.out.println("Emter size<100 ");
        size = in.nextInt();
        for (int i =0;i<size;i++){
            System.out.println("Enter "+i+1+"th number");
            a[i] = in.nextInt();

        }
        System.out.println("Length = "+ a.length);
        for (int i =0;i<size;i++)
        System.out.println(a[i]);
    }

    public static void main(String[] args) {
        ArrInitialKey ar = new ArrInitialKey();
        ar.loadArray();
    }
}
class RandomArrInit {
    static int[] a = new int[100];
    static int size;
   static int MIN = 1,MAX = 100;

    static int loadRandomArray(int min , int max) {
       int rand = (int)(Math.random() + (max-min) + 1) + min;
       return rand;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Emter size<100 ");
        size = in.nextInt();
        for (int i =0;i<size;i++){
            System.out.println("Enter "+i+1+"th number");
            a[i] =loadRandomArray(MIN,MAX);

        }
        System.out.println("Length = "+ a.length);
        for (int i =0;i<size;i++)
            System.out.println(a[i]);
    }
}
class CloneArr{
    int[] a = {1,2,3,4,5};
    int[] b = (int[])a.clone();//Can clone an array into another array
    void loadArray(){
        Scanner in = new Scanner(System.in);

        System.out.println("Length = "+ a.length);
        System.out.println("Array a: ");
        for (int i =0;i<a.length;i++)
            System.out.println(a[i]);

        System.out.println("Array b: ");

        for (int i =0;i<a.length;i++)
            System.out.println(b[i]);
}

    public static void main(String[] args) {
        CloneArr ar = new CloneArr();
        ar.loadArray();
    }
}

class GenericArr<T>{
    private T[] x;
    public GenericArr(T[] t){
        x = t;
    }
    void  printArr(T[] tarr){
        for(int i=0;i<tarr.length;i++)
            System.out.println(tarr[i]);

    }


    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5};
        GenericArr<Integer> ar = new GenericArr<Integer>(a);
        ar.printArr(a);

    }

}

//EZ PROGRAMS ARE THERE FOR INSERTION AND DELETION OF ARRAYS
//REFER SLIDES
//MATRIX ADDITION , ,ROW-COLUMN MAJOR PRINT MULTI WE KNOW!