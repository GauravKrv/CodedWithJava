import java.util.*;
import java.lang.*;
import java.io.*;

public class CovidTracker {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        int test, N,K,X,Y;
        test = sc.nextInt();
        for(int i=0;i<test;i++){
            ArrayList<Integer> aL = new ArrayList<>();
            N = sc.nextInt();
            K = sc.nextInt();
            X = sc.nextInt();
            Y = sc.nextInt();

            for(int j=0;j<N;j++)aL.add(j);
            int ptr = X;
            for(int k=0;k<N;k = (k+1)%N) {
                if (Y == aL.get((ptr + K) % N)) {
                    System.out.println("YES");
                    break;
                } else {
                    if(aL.get((ptr + K) % N) ==-1){
                        System.out.println("NO");
                        break;
                    }
                    aL.set(((ptr + K) % N),-1);
                    ptr = (ptr + K) % N;

                }
            }
        }
    }
}
