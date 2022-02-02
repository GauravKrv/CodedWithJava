package ARRAYS;

public class FixedPointArray {
   static int fixed_point(int arr[]){

        for (int i = 0;i<arr.length;i++){
            if (arr[i] == i) {
                return i;}
        }
        return -1;
    }

    static int fixed_point2(int arr[], int l, int h){
         if(h >= l){
            int mid = (h+l)/2;
            if (mid==arr[mid]){
                return mid;
            }
            if (mid>arr[mid])
                return fixed_point2(arr,mid+1,h);
            else
                return fixed_point2(arr,l,mid-1);
        }
        return -1;
    }


    public static void main(String[] args) {
       int arr[] = {-10, -5, 0, 3, 7};
        int result;
        result = fixed_point2(arr,0,arr.length-1);
        if (result != -1){
            System.out.println("Fixed point is : "+result);
        }else {
            System.out.println("No fixed point.");
        }
    }
}
/*QUESTION :
Given an array of n distinct integers sorted in ascending order, write a function that
returns a Fixed Point in the array, if there is any Fixed Point present in array,
 else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i.
  Note that integers in array can be negative.
* */

/*
TIME COMPLEXITY :

Method1:Linear Search
Time Complexity: O(n)

Method2:Binary Search
Algorithmic Paradigm: Divide & Conquer
Time Complexity: O(Logn)















* */