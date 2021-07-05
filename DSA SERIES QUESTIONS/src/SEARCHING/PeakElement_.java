package SEARCHING;

import java.util.Scanner;

public class PeakElement_ {
    /*
   A peak element in an array is the one that is not smaller than its neighbours.
Given an array arr[] of size N, find the index of any one of its peak elements.
Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0.

HINT
The complete solution:

The peak element, is the element that is not smaller than its neighbours.
Checking at an element, if it is smaller than its right neighbour, then a peak element exists at its right. (Why ?)
If it is smaller than its left neighbour, then a peak element exists at its left side. (Why ?)
Do Binary search, with above conditions. Also check at the mid element, if it is not smaller than its neighbours.
Also, consider for corner cases, i.e for index position 0 and n-1, and modify the code accordingly.
    * */

    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] arr,int n)
    {
        int l =0, h = n-1;
        while(l<=h){
            int m = (l+h)/2;
            if((m==0 || arr[m-1]<=arr[m])&&(m==n-1||arr[m+1]<=arr[m])) return m;
            if(m>0 && arr[m-1]>=arr[m]){
                h = m-1;
            }else{
                l = m+1;
            }
            //add code here.
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            int[] tmp=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                tmp[i] = a[i];
            }

            int f=0;
            int A=(new PeakElement_()).peakElement(tmp,n);

            if(A<0 && A>=n)
                System.out.println(0);
            else
            {
                if(n==1 && A==0)
                    f=1;
                else if(A==0 && a[0]>=a[1])
                    f=1;
                else if(A==n-1 && a[n-1]>=a[n-2])
                    f=1;
                else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
                    f=1;
                else
                    f=0;
                System.out.println(f);
            }
        }
    }
}
