package DIV2_751;

public class B extends CodeForces{

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = I();
            }
            int q = I();
            solution(a,n,q);
        }
    }

    private static void solution(int[] a, int n, int q) {
        int[] b = new int[n];
        int[][] c = new int[n+1][n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            c[curr][i] = a[i];
          //  System.out.print(a[i]+" ");
        }
        curr++;
        while (curr<=n){
            for (int i = 0; i < n; i++) {
                b[a[i]-1] += n+1;
            }
            for (int i = 0; i < n; i++) {
                b[i] = b[i]/(n+1);
            }
            for (int i = 0; i < n; i++) {
                //System.out.println("a i = "+a[i]);
                a[i] = b[a[i]-1];
            }
            for (int i = 0; i < n; i++) {
                c[curr][i] = a[i];
               // System.out.print(a[i]+" ");
            }
            //System.out.println();
            curr++;
        }
        while (q-->0){
            int x=I();
            int k=I();
            if(k>=a.length+1)System.out.println(c[n][x-1]);
            else System.out.println(c[k][x-1]);
        }


    }
}
