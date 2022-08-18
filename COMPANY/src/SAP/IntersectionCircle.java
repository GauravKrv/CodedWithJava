package SAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectionCircle {

    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); //for no of testcases
        while (t-- > 0) {

            String s[] = read.readLine().split(" ");
            int X1, Y1, R1, X2, Y2, R2;
            X1 = Integer.parseInt(s[0]);
            Y1 = Integer.parseInt(s[1]);
            R1 = Integer.parseInt(s[2]);
            X2 = Integer.parseInt(s[3]);
            Y2 = Integer.parseInt(s[4]);
            R2 = Integer.parseInt(s[5]);
            Solution ob = new Solution();
            double ans = ob.intersectionArea(X1, Y1, R1, X2, Y2, R2);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    double intersectionArea(int X1, int Y1, int R1, int X2, int Y2,
                          int R2) {
        // code here
        double r0 = R1, r1 = R2, x1 = X2, x0 = X1, y0 = Y1, y1 = Y2;
        // code here

        double PI = 3.14;


        double d = Math.sqrt((x1 - x0) * (x1 - x0) + (y1-y0)*(y1-y0));
        double d1 = ( (r0*r0 - r1*r1 + d*d) / (2 * d));
        double d2 = d - d1;



        double ans = 0.0;

        // Circles do not overlap
        if (d >= r1 + r0)
        {
            return 0;
        }

        // Circle1 is completely inside circle0
        else if (d <= r0 - r1)
        {
            // Return area of circle1
            ans = PI*(r1 * r1);
        }

        // Circle0 is completely inside circle1
        else if (d <= r1 - r0)
        {
            // Return area of circle0
            ans = PI * (r0 * r0);
        }
        // Circles partially overlap
        else
        {

            ans = (r0*r0)*Math.acos(d1/r0) - d1*Math.sqrt(r0*r0 - d1*d1)
                    +
                    (r1*r1)*Math.acos(d2/r1) - d2*Math.sqrt(r1*r1 - d2*d2);


        }
//        return ans;
        return (double) Math.round(ans*1000000)/1000000;
//        return  Math.round(ans*1000000)/1000000.0;
    }
};
