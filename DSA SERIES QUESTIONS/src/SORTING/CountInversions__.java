package SORTING;

import java.util.Scanner;

public class CountInversions__ {
    /*Given an array of integers. Find the Inversion Count in the array.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 5*105
1 ≤ arr[i] ≤ 1018
    * */
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        return inversionCountUtil(arr,0,N-1);

        // Your Code Here
    }

    static long inversionCountUtil(long[] arr,long l,long r){
        long res = 0;
        if(l<r){
            long m = (l+r)/2;
            res += inversionCountUtil(arr,l,m);
            res += inversionCountUtil(arr,m+1,r);
            res += countAndMerge(arr,l,m,r);
        }

        return res;
    }

    static long countAndMerge(long[] arr,long l,long m, long r){
        long n1 = m - l + 1; //***
        long n2 = r - m;
        long[] L = new long[(int)n1];
        long[] R = new long[(int)n2];
        for(long i=0;i<n1;i++){
            L[(int)i] = arr[(int)(l+i)];
        }
        for(long j=0;j<n2;j++){
            R[(int)j] = arr[(int)(m+j+1)];//***
        }

        long i = 0, j=0, k=l, res = 0;
        while(i<n1 && j<n2){
            if(L[(int)i]<=R[(int)j]){
                arr[(int)k++] = L[(int)i++];
            }
            else if(R[(int)j]<L[(int)i]){
                arr[(int)k++] = R[(int)j++];
                res = res + (n1-i); //*********** rest all is merge sort except this line
            }
        }

        while(i<n1){
            arr[(int)k++] = L[(int)i++];
        }
        while(j<n2){
            arr[(int)k++] = R[(int)j++];
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = 5;
        long arr[]  = new  long[5];
        for (long i =0;i<N; i++){
            arr[(int) i] = sc.nextLong();
        }
        System.out.println(inversionCount(arr,5));
    }
}
