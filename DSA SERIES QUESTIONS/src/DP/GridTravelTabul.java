package DP;

public class GridTravelTabul {
    //WORKS BUT SEE THE SOLUTION -- that is eazy -- just to check whether in how many ways current box can be visited following the two rules
    static int gridTravel(int m,int n){
        int[][] tabel = new int[m+1][n+1];

        tabel[1][1] = 1;

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                int curr = tabel[i][j];
                if (j+1<=n) tabel[i][j+1] += curr;
                if (i+1<=m) tabel[i+1][j] += curr;
            }
        }

        return tabel[m][n];
    }

    public static void main(String[] args) {
        System.out.println(gridTravel(3,3));
    }
}
