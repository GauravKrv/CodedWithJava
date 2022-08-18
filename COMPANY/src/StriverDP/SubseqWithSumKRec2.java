package StriverDP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubseqWithSumKRec2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        Integer[] a = new Integer[]{1,2,1,1,1};
        Integer sum = 3;

        List<Object> al = new ArrayList<>();
        solve(0,n,al,a,sum);
        //below is just to check the count of subseq
        System.out.println("Number of subsequece printed : "+numseq);
    }

    static int numseq = 0;
    private static void solve(int i, int n, List<Object> al, Object[] a, Integer sum) {
        //if reached the end of array, print it -   GENERIC
        if (sum==0){
            for (Object x :al) {
                System.out.print(x+" ");
            }
            numseq++;
            System.out.println();
            return;
        }
        if (i>=n) return;

        //TAKE CURRENT item to sum
        al.add(a[i]);
        solve(i+1,n,al,a, sum-Integer.parseInt(String.valueOf(a[i])));

        //NOT-TAKE CURRENT item to sum
        al.remove(al.indexOf(a[i]));
        solve(i+1,n,al,a, sum);
    }


}
