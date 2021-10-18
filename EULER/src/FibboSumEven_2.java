public class FibboSumEven_2 {
    static int fibSum(){
        int sum = 0;
        int a = 1;
        int b = 2;
        while (b<=4000000){
            if (b%2==0){
                sum+=b;
            }
            int c = a+b;
            a = b;
            b = c;
        }
        System.out.println(a);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fibSum());
    }
}
