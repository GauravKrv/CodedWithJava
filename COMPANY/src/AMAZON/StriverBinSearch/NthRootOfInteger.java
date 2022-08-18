package AMAZON.StriverBinSearch;

public class NthRootOfInteger {
    //REMEMBER THIS METHOD
    private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans;
    }
    private static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-6;

        while((high-low)>eps) { //i.e till when we have to do bs -- since real numbers can be infinite bw two digits
            /*AND LOOP WILL STUCK IN FOWLLOWING HIGH - LOW STATE
            *
high-low = 2.220446049250313E-16
high-low = 2.220446049250313E-16
high-low = 2.220446049250313E-16
high-low = 2.220446049250313E-16
* */
            double mid = (low + high) / 2.0; //simple binary search on doubes
            if(multiply(mid, n) < m) { //just a condition
                low = mid;
            }
            else {
                high = mid;
            }
        }

        System.out.println(n+"th root of "+m+" is "+low);

    }
    /*Time Complexity: N x log(M x 10^d)

Space Complexity: O(1)*/
    public static void main (String[] args) {
        int n = 2, m = 2;
        getNthRoot(n, m);
    }

    //GET SQUARE ROOT
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }


}
