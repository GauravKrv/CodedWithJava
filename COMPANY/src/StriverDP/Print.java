package StriverDP;

public class Print {
    static void print(int[][] dp){
        for (int[] x :
                dp) {
            for (int y :
                    x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }

}
