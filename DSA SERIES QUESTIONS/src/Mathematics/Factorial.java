package Mathematics;

public class Factorial {

/*
We can use Kamenetsky’s formula to find our answer !


It approximates the number of digits in a factorial by :
f(x) =    log10( ((n/e)^n) * sqrt(2*pi*n))

Thus, we can pretty easily use the property of logarithms to,
f(x) = n* log10(( n/ e)) + log10(2*pi*n)/2
* */
    public static double M_E = 2.7;
    public static double M_PI = 3.14;
    public int digitsInFactorial(int n){
        if(n==0||n==1) return 1;


        double x = (n * Math.log10(n / M_E) +
                Math.log10(2 * M_PI * n) /  2.0);

        return (int)Math.floor(x) + 1;

    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.digitsInFactorial(120));
    }
}

