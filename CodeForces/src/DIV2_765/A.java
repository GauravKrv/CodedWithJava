package DIV2_765;

import CodeForces.CodeForces;

public class A extends CodeForces {

    public static String toBinary(int x, int len)
    {
        if (len > 0)
        {
            return String.format("%" + len + "s",
                    Integer.toBinaryString(x)).replaceAll(" ", "0");
        }

        return null;
    }

    static void solution(int[] a,int n,int len){
        int[] res = new int[len];
        for (int x :
                a) {
            String s = toBinary(x,len);
            for (int i = len-1; i >=0 ; i--) {
                if (s.charAt(i)=='1'){
                    res[i]++;
                }
            }

        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < len; i++) {
            if (res[i]<=n/2){
                sb.append(0);

            }else{
                sb.append(1);
            }

        }

        System.out.println(Integer.parseInt(sb.toString(),2 ));
    }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            int len = I();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = I();
            }
            solution(a,n,len);
        }
    }
}

