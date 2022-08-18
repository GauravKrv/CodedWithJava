package AMAZON.StriverBinSearch;

import java.util.Arrays;
import java.util.Collections;

public class NextGTInSorted {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,4,5,7,9};
        //biarysrearch
        int bs = Arrays.binarySearch(arr,5);
        System.out.println("Index of 5 = " +bs);

        //upperbound - next greater element
        int ub = Arrays.binarySearch(arr,5);
        int ubans = (ub<arr.length-1?arr[ub+1]:-1);
        System.out.println("UpperBound of 5 = "+ubans);

        //lowerbound - next smaller element
        int lb = Arrays.binarySearch(arr,2);
        int lbans = (lb>0?arr[lb-1]:-1);
        System.out.println("LowerBound of 2 = "+lbans);

    }
}
