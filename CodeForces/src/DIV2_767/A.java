package DIV2_767;

import CodeForces.CodeForces;

import java.util.*;
//BELOW PERSISTS BUT ACCEPTED
//WORKS FOR 1ST TESTS THINK OTHER AND SUBMIT
//FAULT IN SORTING THE 2nd array of test 1
/*TEST 1
4
3 10
20 30 10
9 100 10
5 1
1 1 5 1 1
1 1 1 1 1
5 1
2 2 2 2 2
100 100 100 100 100
5 8
128 64 32 16 8
128 64 32 16 8
* */
public class A extends CodeForces {

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            int k = I();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = I();
            }

            for (int i = 0; i < n; i++) {
                b[i] = I();
            }
            Pair[] ap = new Pair[n];
            for (int i = 0; i < n; i++) {
                Pair p = new Pair(a[i],b[i]);
                ap[i] = p;
            }
            Compare obj = new Compare();
            obj.compare(ap, n);
//            for (int i = 0; i < n; i++) {
//                System.out.print(ap[i].x + " ");
//            }
//            System.out.println();
//            for (int i = 0; i < n; i++) {
//                System.out.print(ap[i].y + " ");
//            }
//            System.out.println();
            int i = 0;
            while (i<n){
                if (k>=ap[i].x){
                    k+=ap[i].y;
                }
                i++;
            }
            System.out.println(k);

        }
    }
   static class Compare {

        static void compare(Pair arr[], int n)
        {
            // Comparator to sort the pair according to second element
            Arrays.sort(arr, new Comparator<Pair>() {
                @Override public int compare(Pair p1, Pair p2)
                {
                    return p1.x - p2.x;
                }
            });


        }
    }
    static class Pair {
        int x;
        int y;

        // Constructor
        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

}
