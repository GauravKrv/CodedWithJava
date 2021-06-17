package DP;

import java.util.Scanner;

public class SubArrayCount {
    static int subCount = 0;
    static void setSubCount(int[] A,int i){
        if (i<A.length && i+1<A.length && A[i]<A[i+1]){
            subCount++;
            setSubCount(A,i+1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the size of array : ");

        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            //System.out.println("Enet the elements of the array :");
            for (int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();

            for (int i = 0; i < arr.length; i++)
                setSubCount(arr, i);

            subCount = subCount + n;
            //System.out.println("Size of subArrays : "+subCount);
            System.out.println(subCount);
            subCount = 0;
        }

    }
}
