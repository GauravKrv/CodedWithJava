package Mathematics;

public class DivisorsOfN {
//Optimised and O(sqrtN)
    static void printDivisors(int n)
    {
        int i;
        for(i=1; i*i < n; i++)
        {
            if(n % i == 0)
            {
                System.out.print(i+" ");
            }
        }

        for(; i >= 1; i--)
        {
            if(n % i == 0)
            {
                System.out.print((n / i)+" ");
            }
        }
    }

    public static void main (String[] args) {

        int n = 64;

        printDivisors(n);

    }
}