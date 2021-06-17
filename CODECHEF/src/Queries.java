import java.util.*;

public class Queries {
    public static void main(String[] args)  throws java.lang.Exception  {

        Scanner sc = new Scanner(System.in);
        int test, N;
        long K;
        test = sc.nextInt();
        for(int i=0;i<test;i++){
            HashMap<Integer,Long> aL = new HashMap<>();
            long Q=0,left=0;
            N = sc.nextInt();
            K = sc.nextLong();
            for(int j=0;j<N;j++)aL.put((j+1),sc.nextLong());


            for(long j=0;j<N||Q>=0;j++) {
                if(j<N) {
                    Q = aL.get((int) j+1) + left;
                }else {
                    Q = left;
                }
                if (Q>=K){
                    left = Q-K;
                    continue;
                }
                if (Q<K){
                    System.out.println(j+1);
                    break;
                }


            }
        }
    }
}

//(0.530000),Same-->HashTable
//(0.540000),Same-->HshMap