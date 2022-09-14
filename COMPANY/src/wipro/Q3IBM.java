package wipro;

import java.util.Scanner;

public class Q3IBM {


    static int id;
    static int chain = 0, len = 0;
    static int x = 0, y = 0;
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
    static void dfs(int a, int b, int[][] lis, int[][] vis, int r, int c)
    {
        vis[a][b] = id;
        len++;
        if (len > chain)
        {
            x = a;
            y = b;
            chain = len;
        }

        for(int j = 0; j < 4; j++)
        {
            int cx = a + dx[j];
            int cy = b + dy[j];
            if (cx < 0 || cy < 0 ||
                    cx >= r || cy >= c ||
                    lis[cx][cy] == 0 || vis[cx][cy] > 0)
            {
                continue;
            }
            dfs(cx, cy, lis, vis, r, c);
        }

        vis[a][b] = 0;
        len--;
    }

    static void solve(int[][] lis, int r, int c, int[][] vis)
    {
        id++;
        len = 0;
        chain = 0;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if (lis[i][j] != 0)
                {
                    dfs(i, j, lis,vis,r,c);
                    i = r;
                    break;
                }
            }
        }

        id++;
        len = 0;
        chain = 0;
        dfs(x, y, lis,vis,r,c);
        System.out.print(chain);
    }

    // Driver Code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
         int r = sc.nextInt();
         int c = sc.nextInt();
         int [][]vis = new int[r + 1][c + 1];

        // Given grid[][]
        int grid[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        solve(grid,r,c,vis);
    }
}

// This code is contributed by amal kumar choubey
