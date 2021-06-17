package Mathematics;

import java.util.ArrayList;

public class PrimeRelated {
    static boolean isPrime(int n){
        if (n==1) return false;
        if (n==2||n==3) return true;
        if (n%2==0||n%3==0)
            return false;
        for (int i=5;i*i<=n;i+=6){
            if (n%i==0||n%(i+2)==0)
                return false;
        }

        return true;
    }

    static void printPrimesTilln1(int n){
        for (int i=2;i<=n;i++){
            if (isPrime(i))
                System.out.print(i+" ");
        }

    }

    static void sieve(int n){
        ArrayList<Boolean> primeList = new ArrayList<Boolean>(n+1);

        for (int i=0;i<n+1;i++){
            primeList.add(true);
        }
        for (int i=2;i<n+1;i++){
            //System.out.println("Works");
            if (primeList.get(i)){
                System.out.print(i+" ");
                for (int j=i*i;j<=n;j+=i){
                   primeList.set(j,false);
                }
            }
        }

    }//O(N*loglogN)



    public static void main(String[] args) {
        int n = 10000;

        System.out.println(isPrime(23));
//        printPrimesTilln1(n);
//        System.out.println();
//        System.out.println();
        sieve(121);

    }
}
