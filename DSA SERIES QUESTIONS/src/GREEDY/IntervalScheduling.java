package GREEDY;

import java.util.Scanner;

public class IntervalScheduling {

    static void qSort(int l,int h,int arr[][]){
        int j;
        if (l<h){
            j = partition(l,h,arr);
            qSort(l,j,arr);
            qSort(j+1,h,arr);
        }
    }


    static int partition(int l,int h,int arr[][]){
        int pivot = arr[l][0];
        int i=l;
        int j = h;
        while (i < j) {
            do {
                i++;
            }while(i<j && arr[i][0]<=pivot);//if i will give larger elem than the pivot then loop will stop

            do {
                j--;
            } while(arr[j][0]>pivot);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);
        return j;
    }



    static void swap(int arr[][],int i,int j){

        int temp = arr[i][0]; //swap first rows or L's elem
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;

        int temp2 = arr[i][1];   //swap second rows or U's elem
        arr[i][1] = arr[j][1];
        arr[j][1] = temp2;

        int temp3 = arr[i][2];   //swap second rows or U's elem
        arr[i][2] = arr[j][2];
        arr[j][2] = temp3;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] B;
        System.out.println("Enter the number of bookings and the slots : ");
        int n = sc.nextInt();
        B = new int[n][4];
        System.out.println("Enter the start and end time for each slot : \n START TIME\t ENDTIME");
        for (int i=0;i<n;i++){

           B[i][1] = sc.nextInt();
           B[i][0] = sc.nextInt();
           B[i][3] = i+1;
        }

       // printSlots(B,n);
        qSort(0,n,B);
        printSlots(B,n);

        for (int i=0;i<n;i++)
        B[i][2] = i+1;//Renumbering bookings in new sorted order

        int[][] ST = new int[n+1][4];
        for (int i=0;i<n;i++) {
            ST[i][0] = B[i][1];
            ST[i][1] = B[i][0];
            //ST[i][1] = B[i][0];

        }






        int[][] A = new int[n][4];
        A[0][0] = B[0][1];
        A[0][1] = B[0][0];

        int count=0;
        for (int i=0;i<n;i++){
           if (ST[i+1][0]>=B[i][0]) {//if Finish(i)<=Start(i+1)
               A[count][0] = ST[i][0];
               A[count][1] = ST[i][1];
               A[count][2] = B[i][3];
               count++;
           }

        }

        printAcceptedSlots(A,count);


    }

    static void printSlots(int[][] B,int n){
        System.out.println("ID\tSTART TIME\t ENDTIME");
        for (int i=0;i<n;i++){
            System.out.println(B[i][3] + "\t"+B[i][1]+"\t"+B[i][0]);
        }
    }

    static void printAcceptedSlots(int[][] A,int n){
        System.out.println("NAME||START TIME||ENDTIME");
        for (int i=0;i<n;i++){
            System.out.println("\t"+A[i][2]+"\t\t"+A[i][0] + "\t\t"+A[i][1]);
        }
    }
}
/*INPUT
10
1 3
2 4
5 6
6 8
11 14
14 15
16 17
9 10
11 12
12 13

* */
