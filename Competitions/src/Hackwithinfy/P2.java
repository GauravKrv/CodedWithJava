package Hackwithinfy;

import java.util.List;
import java.util.Scanner;

public class P2 {
/*
5
4 5 4
5 3 5
4 3 4
4 5 4
4 5 3
* */

    static int minCSum(int t, List<List<Integer>> a){
        long sum = 0;
        long mod = 1000000007;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 2; j++) {
                if (a.get(i).get(1)<=a.get(i).get(2)){
                    sum+=a.get(i).get(1);
                }else{
                    sum+=(a.get(i).get(2)+1);
                }
            }
            System.out.println(sum);
        }
        return ((int)(sum%mod));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int[][] a = new int[t][4];
        long sum = 0;
        int n = t;


            for (int i = 0; i < t; i++) {
                for (int j = 0; j < 3; j++) {
                    a[i][j] = s.nextInt();
                }
                if (a[i][1]<=a[i][2]){
                    a[i][3]=a[i][1];
                }else{
                    a[i][3]=a[i][2] + 1;
                }
                sum+=a[i][3];
            }

        System.out.println(sum);

    }


    /*

    5
5 5 3
3 5 3
5 3 5
3 3 5
4 4 5
    * */
}
