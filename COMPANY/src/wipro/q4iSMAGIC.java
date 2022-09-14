package wipro;

public class q4iSMAGIC {

    public static int solve(int A)
    {
        int sum = 0;
        while (A > 0 || sum > 9)
        {
            if (A == 0)
            {
                A = sum;
                sum = 0;
            }
            sum += A % 10;
            A /= 10;
        }

        return (sum == 1)?1:0;
    }

    // Driver code
    public static void main(String args[])
    {

        int n = 83557;
        System.out.println(solve(n));

    }
}
