package DIV2_752;

import CodeForces.CodeForces;

public class B extends CodeForces {

//MY --  LWAYS ONLY ONE OPERATION IS REQUIRED

    public static void main(String[] args) {

        int t = I();
        while (t-->0){
            int n = I();
            String s = S();
            solution(n,s.toCharArray());
            System.out.println();
        }
    }
//wrong answer --p ng
    private static void solution(int n, char[] s) {

        StringBuilder sb = new StringBuilder("");
        int one =0;
        int zero = 0;
        //count number of zeroes and ones
        for (char c: s ) {
            if (c=='1'){
                one++;
            }else{
                zero++;
            }
        }
        int i = 0;
        while (i<zero){
            if (s[i]=='1'){
                sb.append(i+1);
            }
            i++;
        }
        i = zero;
        while (i<n){
            if (s[i]=='0'){
                sb.append(i+1);
            }
            i++;
        }
        int l = sb.length();
        if (l>0){
            System.out.println(1);
            System.out.print(l+" ");
            for ( i=0;i<l;i++) {
                System.out.print(sb.charAt(i)+" ");
            }
        }else{
            System.out.print(0);
        }
    }

    private static void solution2(int n, char[] sb) {


        boolean fl = false;
        boolean[] f = new boolean[n];
        int s = 0;
        int e = n-1;
        int count = 0;
        while (s<e){
            s++;
            e--;
          while (s<e){
              if (sb[e]!='0'){
                  e--;
              }else{
                  f[e]=true;
                  count++;
                  break;
              }
          }
            while (s<e){
                if (sb[s]!='1'){
                    s++;
                }else{
                    f[s]=true;
                    count++;
                    break;
                }
            }


        }
        if (count==0){
            System.out.print(0);
            return;
        }

        System.out.println(1);
        System.out.print(count+" ");
        for (int i = 0; i < n; i++) {
            if (f[i]){

                System.out.print((i+1)+" ");
            }
        }
    }
    static String reverse(StringBuilder sb,int s,int e){
        StringBuilder rev = new StringBuilder(sb.subSequence(s,e));
        return String.valueOf(rev.reverse());
    }


}
