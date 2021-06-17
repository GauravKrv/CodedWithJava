package DP;

import java.util.Scanner;

public class GridPathsWithObstacles {

    static int calculateGridPaths(int[][] grid,int[][] path,int x,int y){

        for (int i=0;i<=x;i++){
            for (int j=0;j<=y;j++){
                if (grid[i][j] != 0)
                    grid[i][j] = 1;
            }
        }
        // Initializing the left corner if no obstacle there
        if (grid[0][0] == 1)
            path[0][0] = 1;

        for(int i = 1; i <= x; i++)
        {
            // If not obstacle
            if (grid[i][0] == 1)
                path[i][0] = path[i-1][0];
        }

        for(int j = 1; j <= y; j++)
        {
            // If not obstacle
            if (grid[0][j] == 1)
                path[0][j] = path[0][j-1];
        }


        for (int i=1;i<=x;i++){
            for (int j=1;j<=y;j++){
                if (grid[i][j] == 1){
                    path[i][j] = path[i - 1][j] +
                            path[i][j - 1];
                }
            }
        }

        return path[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the destination coordinates ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] grid = new int[x+1][y+1];
        int[][] path = new int[x+1][y+1];

        for (int i=0;i<=x;i++){
            for (int j=0;j<=y;j++){
                grid[i][j] = -1;
            }
        }

        System.out.println("Enter number of obstacles ");
        int n = sc.nextInt();

        System.out.println("Enter the coordinates of obstacles ");
        while (n-->0){
            grid[sc.nextInt()][sc.nextInt()] = 0;
        }

        int total = calculateGridPaths(grid,path,x,y);

        System.out.println("TOTAL NUMBER OF GRID PATHS  = "+total);

    }


}
