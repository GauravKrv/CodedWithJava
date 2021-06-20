package ARRAYS;

import java.util.Scanner;

public class ArrayInput {
    public  void createArray(int[] arr,int n){
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
    }

    public void printArray(int[] arr,int n){
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
