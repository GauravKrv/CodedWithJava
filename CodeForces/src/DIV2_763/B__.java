package DIV2_763;

import CodeForces.CodeForces;

import java.util.ArrayDeque;
//MY DIDNT WORKED BUT BELOW PSVM WORKED---GOOD ONE
//TOUGH WAS CODING
public class B__ extends CodeForces {
    static class Pair{
        int x;
        int y;
        int d;

        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

        Pair(int x,int y,int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void mains(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            ArrayDeque<Pair> ad = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                Pair p = new Pair(I(),I());
                ad.add(p);
            }
//            for (Pair p :
//                    ad) {
//                System.out.print(p.x+" "+p.y+",,");
//            }
            solution(ad,n);

            System.out.println();
        }
    }

    private static void solution(ArrayDeque<Pair> ad, int n) {
       int x1= 1;
       int y1 = n;
       int d;
        ArrayDeque<Pair> res = new ArrayDeque<>();

        for (Pair p :
                ad) {
            if (p.x == x1|| p.y==y1){
                if (p.x!=x1){
                   d = x1;
                   Pair p3 = new Pair(x1,y1,d);
                   res.push(p3);
                   x1 = p.x;
                   y1 = p.y;
                }else if (p.y!=y1){
                    d = y1;
                    Pair p3 = new Pair(x1,y1,d);
                    res.push(p3);
                    x1 = p.x;
                    y1 = p.y;
                }
            }
        }
    }


    public static void main(String[] args) {

        int t=I();
        while(t-- > 0) {
            int n=I();
            int arX[]=new int[n+1];
            int arY[]=new int[n+1];
            boolean dp[][]=new boolean[n+1][n+1];//taking the dp array size as n+1,n+1
            for(int i=1;i<=n;i++) {
                int x=I();
                int y=I();//taking the ranges
                arX[i]=x;//storing the values of x and y seperately
                arY[i]=y;
                dp[x][y]=true;//marking the cordinate as true
            }
            for(int i=1;i<=n;i++) { //iterating for each range
                for(int d=arX[i];d<=arY[i];d++) { //from d = x to d = y [i.e for each range i]
                    if((d == arX[i] || dp[arX[i]][d-1]) && (d == arY[i] || dp[d+1][arY[i]])) { //if x,d-1 OR d+1,y is present or is true then print current range with d value
                        System.out.println(arX[i]+ " "+arY[i]+" "+d);
                        break;
                    }
                }
            }
        }
    }
}
