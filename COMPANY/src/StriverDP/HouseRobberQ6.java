package StriverDP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HouseRobberQ6 {

    //JUST USING FUNCTION OF Q5 AND SOLVING -- q6 solution
    private static int solve(int n, int[] a) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != 0)
                al.add(a[i]); //excluding 0th neifghbour

            if (i != (n - 1)) //excluding last indexed neighbr
                al2.add(a[i]);
        }

        return Math.max(maxSumNonAdj(n-1,Convert.convertIntegers(al)), maxSumNonAdj(n-1, Convert.convertIntegers(al2)));
    }



    private static int maxSumNonAdj(int n, int[] a) {
        int prev = a[0];
        int curr,prev2=0,take,notake;

        for (int i = 1; i < n; i++) {
            take =  a[i]; //taking each non adjacent one by one
            if (i>1)
                take += prev2;

            notake = 0+prev;

            curr = Math.max(take,notake);//store the max of curr and prev
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[] a = new int[]{10, 20, 30, 10, 30};


        System.out.println(solve(n, a));
    }



}
