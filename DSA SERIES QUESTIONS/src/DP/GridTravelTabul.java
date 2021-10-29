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

//    sir rec
    static int gridTravellerRec(int m,int n){
        if (m==1 && n==1) return 1;
        if (m==0 || n==0) return 0;
//decreasing the row keepin gthe column same and decreasing the column keeping the row same
        return gridTravellerRec(m-1,n) + gridTravellerRec(m,n-1);
    }

    //my memo
    static int gridTravellerMemo(int m,int n, int[][] memo){
        if (memo[m][n] != 0) return memo[m][n];
        if (m==1 && n==1) return 1;
        if (m==0 || n==0) return 0;

        memo[m][n] =  gridTravellerMemo(m-1,n,memo) + gridTravellerMemo(m,n-1,memo);

        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println(gridTravel(3,3));
    }
}
