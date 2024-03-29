package AMAZON.STRINGS;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class wow1 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int D ,K;

        D= 11;
        K= 3;
        System.out.println(minDays(D,K));


    }
    static int minDays(int input1,int input2){
        Integer[] dp = new Integer[1000];
        Arrays.fill(dp,-1);
        List<Integer>  DP = Arrays.asList(dp);
        ArrayList<Integer>  parr = new ArrayList<>();
        int i=2,k=0;
        while(k < input2){
            if(isPrime(i)){
                parr.add(i);
                k++;
            }
            i++;
        }
        return calculateConfidence(input1,parr,DP);

    }
    static final int INT_MAX = Integer.MAX_VALUE;
    static int calculateConfidence(int D, ArrayList<Integer> P, List<Integer> dp)
    {
        if(D==0) return 0;
        if(D<0) return INT_MAX;
        if(dp.get(D) != -1)
            return dp.get(D);
        dp.set(D,INT_MAX);
        for(int i=0;i<P.size();i++)
        {
            int current = calculateConfidence(D-P.get(i),P,dp);
            if(current == INT_MAX) continue;
            dp.set(D,Math.min(dp.get(D),current+1));
        }
        return dp.get(D);
    }
    static boolean isPrime(int n){
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
}