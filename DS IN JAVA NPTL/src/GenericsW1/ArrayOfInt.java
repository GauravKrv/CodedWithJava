package GenericsW1;

public class ArrayOfInt {
    public int a[];
    ArrayOfInt(int a[]){
        this.a = a;
    }
   public void printInt(){
        for(int x =0;x<a.length;x++){
            System.out.println(a[x]);
        }
    }
    void reverseInt(){
        int temp;

            int j = a.length-1;
            System.out.println(j);
            for (int i = 0; i <= j; i++) {

                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
            }

    }

    public static void main(String[] args) {
     /*   int a[] ={1,2,3,4,559};
    ArrayOfInt b =
    b.printInt();
    b.reverseInt();
    b.printInt();*/
       int a[] ={1,2,3,4,55};
        ArrayOfInt aObj =new ArrayOfInt(a);
        aObj.printInt();
        aObj.reverseInt();
        aObj.printInt();
    }

}

//The above prog is used to rev an aray but if we need anothe data typr
//then we hav to write seperate progs for all.
//e.g:
class GenericArray2<T> {
    //Declaring an array, which should store any type T of data---more in GenericArray CLASS
    T a[];

    GenericArray2(T x[]) { // Define a constructor
        a = x;
    }

    static <T> void printData(T b[]) { // A generic method to print the elements in array b
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " "); // Print the i-th element in b
        System.out.println(); // Print a new line
    }
}