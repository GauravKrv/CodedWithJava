public class Solution1 {



    static int maxPrimeFactors(int n)
    {
        int maxP = -1;

        while (n % 2 == 0) {
            maxP = 2;
            n = n/2;
        }
        while (n % 3 == 0) {
            maxP = 3;
            n = n / 3;
        }

        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            while (n % i == 0) {
                maxP = i;
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                maxP = i + 2;
                n = n / (i + 2);
            }
        }

        if (n > 4)
            maxP = n;

        return maxP;
    }

   static int reduction(int n){
        int count = 0;
        while(n>0){
            int temp = maxPrimeFactors(n);
            if (temp!=-1 && temp != n){
                n = temp;
            }else{
                n = n-1;
            }
            count++;
        }
        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 9;
        System.out.println(reduction(n));

    }

}
