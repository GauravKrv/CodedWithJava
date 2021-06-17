package Mathematics;

public class ModularMultiInverse {
    static int modInverse(int a, int m){
        if (gcd(a,m)==1){
            for (int i=0;i<m;i++){
                if((i*a)%m==1){
                    return i;
                }
            }
        }
        return -1;
    }

    static int gcd(int a, int b){
        if (b==0){
            return a;
        }else {
            return gcd(b,a%b);
        }
    }

    public static void main(String[] args) {
        int a = 333;
        int m = 111;
        System.out.println(modInverse(a,m));;
    }
}
