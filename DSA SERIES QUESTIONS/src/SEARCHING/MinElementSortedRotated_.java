package SEARCHING;

import ARRAYS.ArrayInput;
//**********WORKS O(LOGN)
/*
HINT
The minimum element is the only element whose previous element is greater than itself. If there is no previous element greater than current element then there is no rotation (first element is minimum). We check this condition for middle element by comparing it with (mid-1)’th and (mid+1)’th elements.

Traverse over the array using two pointers and use binary search.
If array is not rotated or both pointers are same, return the result.
Check for minimum element at mid and mid+1 and return if found.
If minimum element is not at middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
If middle element is smaller than last element, then the minimum element lies in left half
Else minimum element lies in right half.
* */
public class MinElementSortedRotated_ {
    static int minNumber(int a[], int l, int h)
    {
        int min = a[l];

        while(l<=h){
            min = a[l];

            int m = (l + h)/2;

            if(a[m]>=min){     //CSE 1
                if(a[m]<=a[h]){ //CASE1.1
                    return min;
                }
                else{           //CASE 1.2 & 1.3
                    l = m+1;
                }
            }
            else if(a[m]<min){  //CASE 2
                if(a[m-1]>a[m]){ //CASE 2.1
                    return a[m];
                }else{
                    h = m-1;    //CASE2.2
                }
            }
        }
        return a[l];
        // Your code here
    }

    public static void main(String[] args) {
        try {
            while (true) {
                ArrayInput ar = new ArrayInput();
                int[] arr = ar.createArray(10);
                ar.printArray(arr, 10);
                int min = minNumber(arr, 0, 9);
                System.out.println();
                System.out.println(min);
                System.out.println();
            }
        }catch (Exception e){
            System.out.println("Program terminated");
        }
//2 3 4 5 6 7 8 9 10 1.
    }
}
