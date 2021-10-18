package Mathematics;

public class CalDigitsInFact {
    public static long digitsInFactorial(long N){
        long  n = calculate_fact(N);
        // return floor(log(10*n)+1);
        int c=0;
        while(n!=0){
            n = n/10;
            c++;
        }
        return c;
        // code here
    }
    public static long calculate_fact(long n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            System.out.print(n+" ");
            return n * (calculate_fact(n - 1));
        }
        //
    }
    public static double M_E = 2.71828182845904523536; //OR Math.E
    public static double M_PI = 3.141592654; //OR Math.PI

    public static int digitsInFactorialO1(int n){
        if(n==0||n==1) return 1;


        double x = (n * Math.log10(n / M_E) +
                Math.log10(2 * M_PI * n) /  2.0);

        return (int)Math.floor(x) + 1;
    }


    public static void main(String[] args) {
        System.out.println(digitsInFactorialO1(120));
    }
}
