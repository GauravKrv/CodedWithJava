package DIV2_747;

import CodeForces.CodeForces;

public class QB extends CodeForces {
    static int solution(int n,int k)
    {
        int ans =0;
        int mod = 1000000007;
        long j = 1;
        while (k>0){
            if (k%2==1){
                ans = (int) ((ans + j)%mod);
            }
            j=(j*n)%mod;
            k = k/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            System.out.println(solution(I(),I()));
        }
    }
}
