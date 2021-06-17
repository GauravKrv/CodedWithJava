import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class QueriesCount {
    public static void main(String[] args)  throws java.lang.Exception  {

        Scanner sc = new Scanner(System.in);
        int test, N;
        long K;
        test = sc.nextInt();
        for(int i=0;i<test;i++){
            Vector<Long> aL = new Vector<>();
            long Q=0;
            N = sc.nextInt();
            K = sc.nextLong();
            for(int j=0;j<N;j++)aL.add(sc.nextLong());

            for(long j=0;j<N||Q>=0;j++) {
                if (j < N) {
                if (aL.get((int) j) < K) {
                    Q = K - (aL.get((int) j) + Q);
                    if (Q < 0) {
                        Q = Q * (-1);
                        continue;
                    } else if (Q > 0) {
                        System.out.println(j + 1);
                        break;
                    } }

                    if (aL.get((int) j) >= K) {
                        Q = Q + (aL.get((int) j) - K);
                        continue; }

                } else {
                    if (Q >= K && j >= N) {
                        Q = Q - K;
                        continue;
                    }
                    if (Q < K && j >= N) {
                        System.out.println(j + 1);
                        break;
                    }

                }
            }
                }
            }
    }

