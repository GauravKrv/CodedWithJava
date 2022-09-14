package wipro;

import java.util.Scanner;

public class q2ibm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kc = sc.nextInt();
        int p[] = new int[kc];
        int max = 0;
        for (int i = 0; i < kc; i++) {
            p[i] = sc.nextInt();
            max = Math.max(p[i],max);

        }
        System.out.println(solve(p,kc));

    }
    static int solve(int p[],int n){
        int sum = 0;
        int[] ld = new int[n];
        if (n == 1)
        {
            return 1;
        }
        for(int i = 0; i < n; i++) {
            ld[i] = 1;
        }
        for(int i = 0; i < n - 1; i++) {
            if (p[i + 1] > p[i]) {
                ld[i + 1] = ld[i] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--)
        {
            if (p[i] > p[i + 1] &&
                    ld[i] <= ld[i + 1])
            {

                ld[i] = ld[i + 1] + 1;
            }
            sum += ld[i];
        }

        sum += ld[n - 1];
        return sum;
    }
}
