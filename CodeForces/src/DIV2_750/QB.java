package DIV2_750;

import CodeForces.CodeForces;

public class QB extends CodeForces {

    static long solution(int[] arr){
        int zero = 0;
        int one = 0;
        for (int x :
                arr) {
            if (x==0)  zero++;
            if (x==1) one++;
        }

        return one*(1L<<zero);
        
    }
    public static void main(String[] args) {


        int t = I();
        while (t-->0){
            int n = I();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = I();
            }
            System.out.println(solution(arr));
        }
    }
}
