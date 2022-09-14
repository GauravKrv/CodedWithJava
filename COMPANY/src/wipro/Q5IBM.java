package wipro;

import java.util.LinkedList;
import java.util.List;

public class Q5IBM {
    public static int solve(int A, int B) {
        return Integer.bitCount(B-1) & 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(2,2));
        System.out.println(kthGrammar(2,1));
    }

    public static int kthGrammar(int N, int K) {

        List<Integer> list = new LinkedList<Integer>();
        list = generateNextrow(N);
        return list.get(K-1);
    }

    public static List<Integer> generateNextrow(int n)
    {
        List<Integer> list = new LinkedList<Integer>();
        if(n == 1)
        {
            list.add(0);
            return list;
        }

        list.add(0);

        for(int i = 1; i < n; i++)
        {
            int len = list.size();
            for(int j = 0; j < len; j++)
            {
                list.add(list.get(j)^1);
            }

        }
        return list;
    }
}
//        3
//        3
//        1 1 0
//        0 1 0
//        1 1 1