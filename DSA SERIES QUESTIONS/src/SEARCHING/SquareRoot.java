package SEARCHING;

import java.util.Scanner;

public class SquareRoot {
    /*Given an integer x, find the square root of x.
    If x is not a perfect square, then return floor(√x).
    * */
    static long floorSqrt(long x)
    {
        long low =1,high =x, ans =-1;
        while(low<=high){
            long mid = (low+high)/2;
            long msq = mid*mid;
            if(msq == x) return mid;
            else if(msq>x) high = mid-1;
            else{
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
        // return (long)(Math.floor((long)Math.log((double)x)/(long)Math.log((double)2)));
        // Your code here
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            long a = sc.nextInt();

            System.out.println(floorSqrt(a));
            t--;
        }
    }
}
