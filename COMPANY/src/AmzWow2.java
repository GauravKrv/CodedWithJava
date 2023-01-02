import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AmzWow2 {
    static int solve(int a[][], int m,int n){
        int sq = Math.max(m, n);
        int sum = 0;
        int res[][] = new int[sq][sq];
        Map<Integer,Integer> hash = new HashMap<>();

        for (int[] x : res) {
            Arrays.fill(x, 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < sq; i++) {
            hash.put(res[i][i],0);
        }

        for (int i = 0; i < sq; i++) {
            for (int j = 0; j < n; j++) {
                if (hash.containsKey(res[i][j])){
                    hash.put(res[i][j], hash.get(res[i][j])+1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> x : hash.entrySet()) {
            if (x.getValue()>1 && x.getValue()%2==0) sum+=x.getKey();
        }

        return sum;

    }

    public static void main(String[] args) {
//        int m = 2,n=3;
        int m = 3,n=2;
//        int a[][] = {{4,2,3},{4,5,6}};
        int a[][] = {{4,7},{5,5},{4,6}};
        System.out.println(solve(a,m,n));
    }
}
