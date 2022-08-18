package GOOGLE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Q4 {
    static void solution(ArrayList<Integer> ad,int k){
        int i =0;
        if (k>=ad.size()) k = ad.size()-1;
        while(i<k){
            int temp = ad.get(k);

            ad.set(k,ad.get(i));

            ad.set(i,temp);
            i++;
            k--;
        }
        for (int x :
                ad) {
            System.out.print(x+" ");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ad = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ad.add(sc.nextInt());
        }
        int k = sc.nextInt();
        solution(ad,k-1);

    }
}
