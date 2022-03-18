package DIV2_773;

import CodeForces.CodeForces;

public class A extends CodeForces {

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int[] x = new int[3];
            int[] y = new int[3];
            for (int i = 0; i < 3; i++) {
                x[i] = I();
                y[i] = I();
            }
            System.out.println(solution(x,y));
        }
    }

    private static int solution(int[] x, int[] y) {
        if (y[1]==y[2]){
            if (y[0]<y[1]){
                return Math.abs(x[1]-x[2]);
            }
        }else if (y[1]==y[0]){
            if (y[2]<y[1]){
                return Math.abs(x[1]-x[0]);
            }
        } else if (y[0]==y[2]){
            if (y[1]<y[0]){
                return Math.abs(x[0]-x[2]);
            }
        }

            return 0;

    }
}
