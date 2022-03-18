package DIV2_766;

import CodeForces.CodeForces;

import java.util.HashMap;

public class B extends CodeForces {
    static void solution(int n,int m){
        HashMap<Integer,Integer>  hm= new HashMap<>();



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cx,cy;
                if (i<=n/2) cx = 0;
                else cx = n-1;

                if (i<=m/2) cy = 0;
                else cy = m-1;

                int dist = Math.abs(i-cx) + Math.abs(j-cy);
                hm.put(dist,hm.get(dist)+1);

            }
        }

        for (int x: hm.values()
             ) {
            while (x>0){

            }
        }

    }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            int m = I();
            solution(n,m);
        }
    }
}
