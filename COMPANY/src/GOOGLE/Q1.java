package GOOGLE;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    static int count = 0;
    static void solution(int[] s,int x,int l,int r){

        while (l<=r){
            int mid = (l+r)/2;
            if(s[mid] > x){
                r = mid-1;
               // System.out.println("l - "+r);
            }else if(s[mid]<x){
                l = mid+1;
                //System.out.println("l - "+l);
            }else{

                count++;
              solution(s,x,mid+1,r);
                solution(s,x,l,mid-1);
                break;
            }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        solution(arr,x,0,n-1);
        System.out.println(count);
    }
}
