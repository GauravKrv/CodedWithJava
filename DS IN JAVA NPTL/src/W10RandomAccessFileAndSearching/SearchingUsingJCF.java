package W10RandomAccessFileAndSearching;

import java.util.Arrays;

public class SearchingUsingJCF {
    /*
    METHOD OF CLASS ARRAYS FOR SEARCHING ==>
    int binarySearch(<T> array[ ], <T> value) ==>It searches for the specified element in the array with the help of
    Binary Search algorithm. It returns the index of an array location, if found else NULL.
Methods of class Arrays for searching ===>
The binarySearch( ) method uses a binary search to find a specified value. This method must be applied to
sorted arrays. Here are some of its forms.
static int binarySearch(byte array[ ], byte value)
static int binarySearch(char array[ ], char value)
static int binarySearch(double array[ ], double value)
static int binarySearch(float array[ ], float value)
static int binarySearch(int array[ ], int value)
static int binarySearch(long array[ ], long value)
static int binarySearch(short array[ ], short value)
static int binarySearch(Object array[ ], Object value)
static int binarySearch(T[ ] array, T value, Comparator<? super T> c)
Note: Array of type boolean is not applicable to such a method.

MOTHOD OF CLASS ARRAYS FOR SEARCHING IN A PORTION OF AN ARRAY :::
    int binarySearch(<T> array[ ], int start, int end, <T> value) ==>
It searches for the specified element in the sub array from the location start to
end, both inclusive with the help of Binary Search algorithm. It returns the index
of an array location, if found else NULL.

Note: • This method is not applicable to an array of type boolean.

    * */
}
//1.BINARY SEARCH ON AN ARRAY
// This program illustrates the use of Binary Search method.
 class BinarySerachArraysDemo {
    public static void main(String[] args){
// Get the Array
        int intArr[] = { 10, 20, 15, 22, 35};
        Arrays.sort(intArr);
        int intKey = 22;
        System.out.println(intKey
                + " found at index = "
                + Arrays.binarySearch(intArr, intKey));
    }
}
//2.1.BINARY SEARCH ON A SUB ARRAY
/* This program illustrates the use of Binary Search method within a sub
list. */
class ArraysBinarySerachSubListDemo {
    public static void main(String[] args){
        int intArr[] = { 10, 20, 15, 22, 35}; // An int array as input
        Arrays.sort(intArr); // Sort the array
        int intKey = 22;
        System.out.println ( intKey + " found at index = "
                + Arrays.binarySearch(intArr, 1, 3, intKey));
    }
}