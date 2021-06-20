package Mathematics;

public class GCD {
    static int gcd(int a, int b){
        if (b==0)
            return a;
        return gcd(b,a%b);
    }

    static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) {
        int a = 32, b = 64;
        System.out.println("GCD OF "+a+" and "+b+ " = "+gcd(a,b));
        System.out.println("LCM OF "+a+" and "+b+ " = "+lcm(a,b));
    }
}
