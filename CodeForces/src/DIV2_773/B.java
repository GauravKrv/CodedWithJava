package DIV2_773;

import CodeForces.CodeForces;

import java.util.HashSet;

public class B extends CodeForces {



    public static void main(String[] args) {
        int t=I();
        while (t-->0){
            int n = I();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = I();
            }
            solution(a,n);
            System.out.println();

        }
    }

    private static void solution(int[] a, int n) {
        HashSet<Integer> h = new HashSet<>();
        for (int x :
                a) {
            h.add(x);
        }
        int s = h.size();
//        System.out.println("SIZE = "+s);
        System.out.print(s+" ");
        int k =2;
        while (k<=s){
            System.out.print(s+" ");
            k++;
        }

        while (k<=n){
            System.out.print(k+" ");
            k++;
        }
    }
}

