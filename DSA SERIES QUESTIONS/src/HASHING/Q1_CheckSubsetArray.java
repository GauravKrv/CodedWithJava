package HASHING;

import java.util.Scanner;

public class Q1_CheckSubsetArray {
 /*THEORY:
 Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not.
 Both the arrays are not in sorted order.
 It may be assumed that elements in both array are distinct.

 Examples:

Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
Output: arr2[] is not a subset of arr1[]
 * */


 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array 1");
        int n1 = sc.nextInt();
        int arr[] = new int[n1];
        System.out.println("Ente elemetns in array1 : ");
        for (int i =0;i<n1;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter size of array 1");

        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        System.out.println("Ente elemetns in array2 : ");
        for (int i =0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }

        int max = 20;
        for (int i=0;i<n1;i++){
          if (max<arr[i] ) max = arr[i];
        }



        boolean arrHas[][] = new boolean[max+1][2];

        TrivialHashing_1 thash = new TrivialHashing_1(max,arrHas);

        thash.insert(arr,n1);
        boolean flag = true;

        for (int i=0;i<n2;i++) {
            if (thash.search(arr2[i])) {
                continue;

            } else {
                flag = false;
            }

        }

        if (flag) System.out.println("Subset");
        else System.out.println("Not subset");

 }


 /*OUTPUT
 Enter size of array 1
5
Ente elemetns in array1 :
1 2 3 4 5
Enter size of array 1
3
Ente elemetns in array2 :
1 3 5
Subset
 * */
}














