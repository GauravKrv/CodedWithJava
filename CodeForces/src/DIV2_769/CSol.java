package DIV2_769;

import CodeForces.CodeForces;

public class CSol extends CodeForces {

   static int solution(int a,int b){
       if (a==b) return 0;
       if (Math.abs(a-b)==1) return 1;
       else return 1+Math.min(Math.abs(a-b),Math.min(ored(a,b),Math.min(adda(a,b),addb(a,b))));
   }

   static int ored(int a,int b){
      a = a|b;
      return solution(a,b);
   }
    static int adda(int a,int b){
    a += 1;
    return solution(a,b);
    }
    static int addb(int a,int b){
   a -= 1;
   return solution(a,b);
    }
    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int a = I();
            int b = I();
            solution(a,b);
        }
    }
}
