package SORTING;

import java.util.Arrays;

public class SortAbsDiffWithK {
//NOT WORKING
    //Function to sort the array according to difference with given number.
    static boolean comp(int arr[],int k){
        return Math.abs(arr[0]-k) > Math.abs(arr[1]-k);
    }
    static String sortABS(int arr[], int n,int k)
    {
        // add your code here
        for(int i=0;i<n;i++){
            arr[i] = Math.abs(arr[i]-k);
        }

        return Arrays.toString(arr);

    }

    public static void main(String[] args) {
            int arr[] = {10,5,3,9,2};
                    //{11,2,33,44,5,66,7,8};
            String s = sortABS(arr,5,7);
        System.out.println(s);
    }
}
