package EduRound120;

import CodeForces.CodeForces;

public class D extends CodeForces {
//not coded- incomplete
    static int solution(int n,int k, String bin){
        if (k == 0) return 1;
        return 0;
    }
    public static void main(String[] args) {
        int t = I();
        while(t-->0){
            int n = I();
            int k = I();

            String bin = S();

            System.out.println(solution(n,k,bin));
        }
    }
}
