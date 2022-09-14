package wipro;

import java.util.Scanner;

public class WileyQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int n = sc.nextInt();

        if (n<0)
            System.out.println(-1);
        else
        System.out.println(iskaprekar(n)?"TRUE":"FALSE");
        }catch (Exception e){
            System.out.println(-1);
        }

    }


    static boolean iskaprekar(int n)
    {
        if (n == 1)
            return true;

        int sq = n * n;
        int cntdig = 0;
        while (sq != 0)
        {
            cntdig++;
            sq /= 10;
        }

        sq = n*n;

        for (int rdig=1; rdig<cntdig; rdig++)
        {
            int eq = (int) Math.pow(10, rdig);
            if (eq == n)
                continue;
            int sum = sq/eq + sq % eq;
            if (sum == n)
                return true;
        }
        return false;
    }
}

