package ARRAYS;

public class MaxCircularArray_ {
    //O(N)
    /*
    Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contiguous subarray sum.
Example 1:
Input:
N = 7
arr[] = {8,-8,9,-9,10,-11,12}
Output:
22
* */
    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        int maxNormal = kadane(a,n);
        if(maxNormal<0){
            return maxNormal;
        }

        return Integer.max(maxNormal,reverseKadane(a,n));

        // return Integer.max(kadane(a,n), reverseKadane(a,n));
    }

    static int kadane(int a[], int n) {
        // Your code here
        int res = a[0];
        int maxEnding = a[0];
        for(int i=1;i<n;i++){
            maxEnding = Integer.max(maxEnding+a[i],a[i]);
            res = Integer.max(res,maxEnding);
        }
        return res;
    }

    static int reverseKadane(int a[], int n) {
        int arrSum = 0;
        for(int i=0;i<n;i++){
            arrSum += a[i];
            a[i] = -a[i];
        }
        return arrSum + kadane(a,n);
    }

    public static void main(String[] args) {
        int A[] = {1,3,5,2,2};
        int num = circularSubarraySum(A,5);
        System.out.println(num);
    }
}
