package W11_SORTING;

import java.util.Arrays;

public class SortingUsingJCF {
/*1ST VERSION
The sort( ) method sorts an array so that it is arranged in ascending order. The sort( ) method has two versions.
The first version, shown here, sorts the entire array:
""static void sort(<T> array[ ]) ==>The methods sorts an array in ascending order""

ANNY COLLECTION i.e list can be converted to ARRAY then we can easily sort it as array.
We dont know why other collection didnt implemented sorting technique,and We lso dont know
whcih sorting technique is used in sort method,possible it can be QUICKSORT as it is the
most efficien way to sort.

static void sort(byte array[ ])
static void sort(char array[ ])
static void sort(double array[ ])
static void sort(float array[ ])
static void sort(int array[ ])
static void sort(long array[ ])
static void sort(short array[ ])
static void sort(Object array[ ])
static void sort(T array[ ], Comparator<? super T> c)
Note: Array of type boolean is not applicable to sort a method
* */

/*2ND VERSION
JDK 8 adds several new methods to Arrays. Perhaps the most important is parallelSort( ) because it sorts, into
ascending order, portions of an array in parallel and then merges the results,it is most
efficient sorting emthod in jav becoz java can support multithreading,it works for large set of numbers
or data

"static void parallelSort(<T> array[ ]) The methods sorts an array in ascending order"

static void parallelSort(byte array[ ])
static void parallelSort(char array[ ])
static void parallelSort(double array[ ])
static void parallelSort(float array[ ])
static void parallelSort(int array[ ])
static void parallelSort(long array[ ])
static void parallelSort(short array[ ])
static void parallelSort(T array[ ], Comparator<? super T> c
* */
}
//1.
/* The following method demonstrates the sorting using Arrays’s sort method.
 */

class ArraysSortDemo {
    public static void main(String args[]) {
// Allocate and initialize array.
        int array[] = new int[10];
        for(int i = 0; i < 10; i++)
            array[i] = i%3; // Alternatively, you can load random numbers
        System.out.print("Original contents: ");
        for (int i=0;i<array.length;i++)
            System.out.print(array[i] + " ");

        System.out.println();
        Arrays.sort(array);
        System.out.print("Sorted: ");

        for (int i=0;i<array.length;i++)
        System.out.print(array[i]+" ");
    }
}

