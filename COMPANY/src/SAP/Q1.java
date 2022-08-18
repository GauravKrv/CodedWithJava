package SAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
class C extends Cd{
    public C(){
      super();
    }
    public void getAllDetails(){
//        super();//er in line 8
    }
}
class Cd {

}
public class Q1  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        solve(a,b,c);
        int ans[] = solve(a);
        for (int x :
                ans) {
            if (x==0) break;
            System.out.print(x+" ");
        }


    }

    private static int[] solve(int[] a, int b, int c) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int x :
                a) {
            if (Math.abs(x) >= b && Math.abs(x) <= c) {
                al.add(x);
            }
            }
        int res[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {

            res[i] = al.get(i);
        }

        return res;
    }
    static int[] solve(int a[]){
        int ans[] = new int[100];
        HashMap<Integer,Boolean> mp = new HashMap<>();
        int c = 0;
        for (int i = 0; i < a.length; ++i)
        {
            if (mp.get(a[i]) == null) {
                ans[c] = a[i];
                mp.put(a[i], true);
                c++;
            }

        }
        int k[] = new int[c];
        for (int i = 0; i < c; i++) {
            k[i] = ans[i];
        }
        return k;
    }


}
