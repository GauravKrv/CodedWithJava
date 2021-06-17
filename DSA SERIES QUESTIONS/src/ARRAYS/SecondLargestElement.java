package ARRAYS;

import java.util.Arrays;
import java.util.Collections;

public class SecondLargestElement {
   static void secondLargestElement(int arr[]){
        Arrays.sort(arr);
        boolean flag = false;
        int temp = arr.length-1;
        for (int i =arr.length-2;i>=0;i--){
            if (arr[i] == temp){
                continue;
            }else {
                temp = arr[i];
                flag = true;
                break;
            }
        }
        if (flag == true){
            System.out.println("Second largest element in the given array is "+temp);
        }else {
            System.out.println("Array elements are same.");
        }
    }

    static void secondLargestElement2(int arr[]){
        Arrays.parallelSort(arr);
        boolean flag = false;
        int temp = arr.length-1;
        for (int i =arr.length-2;i>=0;i--){
            if (arr[i] == temp){
                continue;
            }else {
                temp = arr[i];
                flag = true;
                break;
            }
        }
        if (flag == true){
            System.out.println("Second largest element in the given array is "+temp);
        }else {
            System.out.println("Array elements are same.");
        }
    }

    static void secondLargestElement3(int arr[]){
        boolean flag = false;
        int temp=arr[0];
        int temp2=arr[0];
        for (int i =arr.length-1;i>=0;i--){
            if (arr[i] > temp){
               temp2 = temp;
                temp = arr[i];
                 flag = true;
                }else {
               continue;
            }
        }
        if (flag == true){
            System.out.println("Second largest element in the given array is "+temp2);
        }else {
            System.out.println("Array elements are same.");
        }
    }



    public static void main(String[] args) {

        int arr[] = {12,35,1,10,34,1};
       secondLargestElement3(arr);
       int a=20,b = 30;
      /* swap(a,b);
        System.out.println(a + " " + b);*/

    }
}
/*
Complexity Analysis:Method 1

Time Complexity: O(n log n).
Time required to sort the array is O(n log n).
Auxiliary space: O(1).
As no extra space is required.
* */

/*
Complexity Analysis:Method2

Time Complexity: O(n log n).
1. The array is divided into sub-arrays and that
   sub-arrays is again divided into their sub-arrays,
   until the minimum level of detail in a set of array.
2. Arrays are sorted individually by multiple thread.
3. The parallel sort uses Fork/Join Concept for sorting.
4. Sorted sub-arrays are then merged.

* */

/*
Complexity Analysis:Method 3

Time Complexity: O(n).
Auxiliary space: O(1).
As no extra space is required.

 */



