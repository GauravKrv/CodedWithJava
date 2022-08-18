package AMAZON.INT;

import java.util.HashSet;

public class Q1StockConsecutive {
    //WORKS
    public static void main(String[] args) {
        int a[] = {1,2,7,7,4,3,6};

        int k = 3;
        int n = 7;

        HashSet<Integer> h = new HashSet<>();
        System.out.println(solve2(a,k,h,n-1));
    }

    private static int solve(int[] a, int k, HashSet<Integer> h, int i) {
//        if (k==0) return 0;
//        if (i==0 && k==1 && !h.contains(a[i])){
//            return a[i];
//        }
//        if (i==0) return -(int) 1e9;

        if (k==0) return 0;
        if (i<0 && k==0) return 0;
        if (i<0) return -(int) 1e9;

        int take = -(int) 1e9;
        if (!h.contains(a[i])){
            h.add(a[i]);
            take = solve(a, k-1, h, i-1) + a[i];
            System.out.println(h);
            h.remove(a[i]);
        }
        int notake = solve(a, k, h, i-1);

        return Math.max(take,notake);
    }

    //workss
    private static int solve2(int[] a, int k, HashSet<Integer> h, int i) {

        int max = 0,sum = 0;
        for (int j = 0; j <= a.length - k; j++) {
            sum = a[j];
            h.clear();
            h.add(a[j]);
            for (int l = j+1; l < (j+k); l++) {
                if (!h.contains(a[l])){
                    h.add(a[l]);
                    sum+=a[l];
                }else{
                    sum+=-(int) 1e9;
                    continue;
                }
            }
            max = Math.max(sum,max);

        }
        return max;

    }
}
