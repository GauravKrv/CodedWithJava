package DP;

import java.util.Scanner;


public class RainwaterTrappng1 {
/*
given n non negatve integers representing an elevatoin map where the width of each bar is 1
compute how much water it can trap after rain
TRAPPING RAINWATER PROBLEM 1


* */

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr,n);
    }

    private static void solution(int[] arr, int n) {

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = arr[0];
        suffix[n-1] = arr[n-1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(arr[i],prefix[i-1]);
        }

        for (int i = n-2; i >=0; i--) {
            suffix[i] = Math.max(arr[i],suffix[i+1]);
        }

        int res=0;
        for (int i = 0; i < n; i++) {
            res=res+ Math.min(prefix[i],suffix[i]) - arr[i];
        }

    }

    private static void solution2(int[] arr, int n) {
        int left =0;
        int right = n-1,res=0;
        //check arr left elemennt is min than the array rit=ght pointung element if so, move left and take its water else move right and take water
        int leftmax=0;
        int rightmax=0;

        while(left<=right){
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftmax) {
                    leftmax = arr[left];
                } else {
                    res += leftmax - arr[left];
                }
            }else{
                if (arr[left] >= rightmax) {
                    rightmax = arr[right];
                } else {
                    res += rightmax - arr[right];
                }
            }
        }
        System.out.println("result is :"+res);
    }
}
