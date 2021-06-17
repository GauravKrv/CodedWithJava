import java.util.Arrays;
import java.util.Comparator;

public class ArraysW3L4 {
    /*
    ARRAYS
    1.When to use Arrays and when to use ArrayList of JCF
    --Classes in JCF Speeds up our programs
    --Java provides Arrays concept which is a part of JCF
    --There are many methods defined in arrays class but there are no constructors of Arrays.
    --Arrays class is popular due to its searching and sorting algorithm
    --Arrays class is defined in java.util package.
    This class name is in plural form “Arrays” because it can handle java arrays of different
primitive types like byte, char, short, int, long, float, double, and universal type Object.
• This class Arrays has been designed to bridge the gap between collections and Java
arrays.
•  In fact, Arrays  consists of only static methods and the methods of Object class.
THEREFORE the methods of this class can be used by the class name itself. That is, no object of the
class Arrays need to be created to access a method in it.
• The following is the syntax to access a method in Arrays.
Arrays.<methodName (. . .)<T>;
Here, <T> denotes a type parameter. This type parameter includes boolean,
byte, char, short, int, long, float, double, and Object.

    METHODS IN ARRAYS---
    1.<T>ListasList(<T> array) ---It returns a List that is backed by an array of type T. Both the list and array refer
to the same location.
    2.Int binarySearch(<T> array[ ], <T> value)--->It searches for the specified element
    in the array with the help of Binary Search algorithm.
    It returns the index of an array location, if found else NULL. Array of
    type boolean is not applicable to such a method.
    3.<T>[ ] copyOf(<T>[ ] source, int len)---> It returns a copy of an array source and len
    is the length of the copy. If the copy is longer than source, then the copy is padded
     with zeros (for numeric arrays), nulls (for object arrays), or false (for boolean arrays).
     If the copy is shorter than source,then the copy is truncated.

    4.<T>[ ] copyOfRange(<T>[ ] source, int start, int end) --->It returns a copy of a range
    within an array in from start to end‐1.
     5.boolean equals(<T> array1[ ], <T> array2 [ ])---> It returns true if two arrays are equivalent, otherwise, it
    returnsfalse. Here, array1 and array2 should be comparable for equality.
    6.boolean deepEquals(Object[ ] a, Object[ ] b)---> The method can be used to determine if two arrays, which
might contain nested arrays, are equal.
    7.void fill(<T> array[ ], <T> value)---> It fills an array with a specified value.
    8.void fill(<T> array[ ], int start, int end, <T>value) ---->It fills an array with a
    specified value to a subset of an array from position start to end‐1.
    9.void sort(byte array[ ]) --->It sorts an array so that it is arranged in ascending order.
    10.void sort(<T> array[ ], int start, int end) --->It sorts a subarray in ascending order
    between the position start and end‐1.
    11.void parallelSort(byte array[ ]) --->it sorts, into ascending order, portions of
    an array in parallel and then merges theresults.
    12.void parallelSort(<T> array[ ], int start, int end) --->It sorts a subarray in
    ascending order between the position start and end‐1 in parallel.

    OPERATIONS WITH ARRAYS:

    * */

}


































//-----------------------------------------------------------------------//

//1.Converting array into a colection of object
class ArrayToListDemo {
    public static void main(String[] args) {
        int intArr[] = { 10, 20, 15, 22, 35}; // An array of int
        System.out.println("Integer Array as List: " );
        for (int i =0;i<intArr.length;i++)
        System.out.println( Arrays.asList(intArr[i])); // To convert the elements as List
    }
}

//2.Stream representation of arrays
 class ArraysToStreamDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[] = { 10, 20, 15, 22, 35};
        System.out.println("Integer Array: ");
// To get the Stream from the array
        for (int i =0;i<intArr.length;i++)
            System.out.println(Arrays.stream(intArr));
    }
}//---->not works

// 3.Converting array items into String objects
class ArraysToStringDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[] = { 10, 20, 15, 22, 35};
// To print the elements in one line
        System.out.println("Integer Array: "
                + Arrays.toString(intArr));
    }
}

//4.Converting array items into String objects-->
class ArraysToDeepStringDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[][] = { { 10, 20, 15, 22, 35},{5,4,3,2,1} };
// To get the deep String of the arrays
        System.out.println("Integer Array: "
                + Arrays.deepToString(intArr));
    }
}

//5.Copying an array to collection
class CopyOfArraysDemo {
    public static void main(String[] args) {
        int intArr[] = { 10, 20, 15, 22, 35}; // An input array
// To print the elements in one line
        System.out.println("Integer Array: " + Arrays.toString(intArr));
                System.out.println("\nNew Arrays by copyOf:\n");
        System.out.println("Integer Array: "+ Arrays.toString( Arrays.copyOf(intArr, 10)));
    }
}

//6. Copying a range of an array to collection
class RangeCopyArraysDemo {
    public static void main(String[] args){
        int intArr[] = { 10, 20, 15, 22, 35}; // Get an array of int
// To print the elements in one line
        System.out.println("Integer Array: " + Arrays.toString(intArr));
        System.out.println("\nNew Arrays by copyOfRange:\n");
// To copy the array into an array of new length
        System.out.println("Integer Array: "
                + Arrays.toString(Arrays.copyOfRange(intArr, 1, 3)));
    }
}
//7.Comparing two arrays
class CompareArraysDemo {
    public static void main(String[] args) {
        int intArr1[][] = { { 10, 20, 15, 22, 35} }; // An input array
        int intArr2[][] = { { 10, 15, 22} }; // Another input array
// To compare both the arrays
        System.out.println("Integer Arrays on comparison: "
                + Arrays.deepEquals(intArr1, intArr2));
        //O/P-->Integer Arrays on comparison: false
    }
}

//8. Hashcode generation of array items
class ArraysOfHashcodeDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[][] = { { 10, 20, 15, 22, 35} };
// To get the dep hashCode of the arrays  --Hashcode is a transformation from one typ of el
        //to other type,
        System.out.println("Integer Array: "
                + Arrays.deepHashCode(intArr));
    }
}
//9: Entering an item into an array
class InsertiontoArraysDemo {
    public static void main(String[] args){
// Get the Arrays
        int intArr[] = { 10, 20, 15, 22, 35};
        int intKey = 22;
        Arrays.fill(intArr, intKey);
// To fill the whole array with the intKey value
        System.out.println("Integer Array on filling: "
                + Arrays.toString(intArr));
    }
}
//if we want to print a collection accord to any elem so it can be
// convrted first to String then using println can be used to prnt the array
//---------------------------------------------------------------------------//
//ARRAYS SEARCHING PROGRAMS

//1.Binary search on an array
class BinarySerachArraysDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[] = { 10, 20, 15, 22, 35};
        Arrays.sort(intArr);//first we have to sort the array before applying bin Search to it
        int intKey = 22;
        System.out.println(intKey + " found at index = "
                + Arrays.binarySearch(intArr, intKey));
    }
}

//2. Binary search on a sub‐list of an array
class ArraysBinarySerachSubListDemo {
    public static void main(String[] args){
        int intArr[] = { 10, 20, 15, 22, 35}; // An int array as input
        Arrays.sort(intArr); // Sort the array
        int intKey = 35;
        System.out.println ( intKey + " found at index = "
                + Arrays.binarySearch(intArr, 1, 4, intKey));
    }
}//-->WRong output -->35 found at index = -5

//---------------------------------------------------------------------------//
//ARRAYS SORTING PROGRAMS*************ARRAYS CAN BE OF ANY TYPE:

//1. Simple sorting
class SortingArraysDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[] = { 10, 20, 15, 22, 35 };
// To sort the array using normal sort
        Arrays.sort(intArr);
        System.out.println("Integer Array: "
                + Arrays.toString(intArr));
    }
}

//2.Sorting a sublist
class SortingSublistDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[] = { 10, 20, 15, 221, 35};
// To sort the array using normal sort
        Arrays.sort(intArr, 1, 3);
        System.out.println("Integer Array: " + Arrays.toString(intArr));
    }
}

//3.Parallel sorting--FASTEST DOWRTING ALGORITHM IS USED HERE=>If time is imp for
//our program then we shoulld use this sorting method.
class ParallelSortDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[] = { 10, 20, 15, 22, 35};
// To sort the array using parallelSort
        Arrays.parallelSort(intArr);//gives fastet sorting outpput
        System.out.println("Integer Array: "
                + Arrays.toString(intArr));
    }
}

//4. Comparator method for sorting
class Student2 {
    int rollno;
    String name, address;
    // Constructor
    public Student2(int rollno, String name, String address){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    // Overriding toString() for Student class for printing
    public String toString(){
        return this.rollno + " " + this.name + " " + this.address;
    }
} // End of class Student2
class Sortbyroll implements Comparator<Student2> {
    public int compare(Student2 a, Student2 b){  // Used for sorting in ascending order of roll number
        return a.rollno - b.rollno;
    }
}
// Driver class
class Sorting{
    public static void main(String[] args){
        Student2[] arr = { new Student2(111, "bbbb", "london"),
                new Student2(131, "aaaa", "nyc"),
                new Student2(121, "cccc", "jaipur") };
        System.out.println("Unsorted");
        for(int i = 0; i<arr.length; i++)
            System.out.println(arr[i]);
        Arrays.sort(arr, 1, 2, new Sortbyroll());
        System.out.println("\nSorted by rollno");
        for(int i = 0; i<arr.length; i++)
            System.out.println(arr[i]);
    }
}///-->WRONG output
//MORE PROGRAMSS ARE THERE IN ORACLE SITES WHICH ARE REQUESTD BY THE PROFFSR TO CHECK