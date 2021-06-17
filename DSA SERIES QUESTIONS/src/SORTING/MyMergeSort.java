package SORTING;

import java.util.Scanner;

public class MyMergeSort {
    static void mergesort(int A[],int l,int r){
        int[] C = new int[A.length];
        while (r>l){
            int mid = l+((r-l)/2);
            mergesort(A,l,mid);
            mergesort(A,mid+1,r);
            merge(A,C,l,mid,r);

        }

        for (int i =0;i<A.length;i++)
            System.out.print(C[i]+" ");
    }
    static void merge(int A[],int C[],int l,int m,int r){
        int k=0;
        int n = r-l;
        while (k<n){
            if (A[l]<A[m]){
                C[k] = A[l];
                k++;l++;
            }
            else if (A[l]>A[m]){
                C[k] = A[m];
                k++;m++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);

        for (int i =0;i<arr.length;i++)
            arr[i] = sc.nextInt();

        mergesort(arr,0,arr.length-1);

    }
}

class MyMergeSort2 {
    static void mergesort(int[] A, int l, int r){
//getting error in this code and now going through
        if (l<r){
            int mid = (l+r)/2;
            mergesort(A,l,mid);
            mergesort(A,mid+1,r);


            merge(A,l,mid,r);

        }


    }
    static void merge(int[] A, int l,int m,int r){
        int n1 = m-l+1;//size of array1
        int n2 = r-m;//size of array2

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i=0;i<n1;++i){
            L[i] = A[l+i];
        }
        for (int i=0;i<n2;++i){
            R[i] = A[m+1+i];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;


        //while (k<n1+n2)--no
        while (i < n1 && j < n2){
            if (L[i]<=R[j]){
                A[k] = L[i];
                k++;i++;
            }
              else { //dont use if here if we are checking i and n in while condition
                A[k] = R[j];
                k++;j++;
            }
        }

        while (i<n1){
            A[k++] = L[i++];
        }
        while (j<n2){
            A[k++] = R[j++];
        }


    }
//12 11 7 2 3 9 8 6 1 0
    public static void main(String[] args) {
      /*  int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);

        for (int i =0;i<arr.length;i++)
            arr[i] = sc.nextInt();*/
        int arr[] = {12,11,13,15,6,7};

        mergesort(arr,0,arr.length-1);

        for (int i =0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

    }
}
