package UnionFind;

public class CountProvinces {
    // Union Find
    public static int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        int count = 0;
        for(int i =0;i<n;i++){
            if (uf.getRoot()[i]==i){
                count++;
            }
        }
//        /*for (int r :
//                uf.getRank()) {
//
//        }*/

        return count;
    }

    public static void main(String[] args) {
//        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};

        System.out.println("No of provinces = "+findCircleNum(isConnected));

    }
}
