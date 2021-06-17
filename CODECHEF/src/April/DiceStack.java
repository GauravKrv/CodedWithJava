package April;

import java.util.Scanner;

public class DiceStack {
    static long maxNum(long n){
        long k = n/4;
        long r = n%4;
        long sum = 0;

            if (r == 0) {
                sum = (k * 44) + 16;
            } else if (r == 1 && k != 0) {
                sum = (k * 44) + 20 + 12;
            } else if (r == 1 && k==0) {
                sum = 20;
            } else if (r == 2 && k != 0) {
                sum = (k * 44) + 36 + 8;
            } else if (r == 2 && k==0) {
                sum = 36;
            } else if (r == 3 && k != 0) {
                sum = (k * 44) + 4 + (2 * 18) + 15;
            } else if (r == 3 && k==0) {
                sum = 36 + 15;
            }


        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();
            System.out.println(maxNum(n));
        }
    }
}
