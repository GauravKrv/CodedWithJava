import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class QueriesCount2 {
    public static void main(String[] args)  throws java.lang.Exception  {

        Scanner sc = new Scanner(System.in);
        int test, N;
        long K;
        test = sc.nextInt();
        for(int i=0;i<test;i++){
            Vector<Long> aL = new Vector<>();
            long Q=0,left=0;
            N = sc.nextInt();
            K = sc.nextLong();
            for(int j=0;j<N;j++)aL.add(sc.nextLong());

            for(long j=0;j<N||Q>=0;j++) {
                if(j<N) {
                    Q = aL.get((int) j) + left;
                }else {
                    Q = left;
                }
             if (Q<K){
                 System.out.println(j+1);
                 break;
             }
             if (Q>=K){
                 left = Q-K;
             }

            }
        }
    }
}

