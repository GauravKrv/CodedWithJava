package SEARCHING;

import ARRAYS.ArrayInput;

import java.util.Scanner;

public class MaxWaterBetweenBuildings_ {
    /*
    Given an integer array representing the heights of N buildings, the task is to delete N-2 buildings such that the water that can be trapped between the remaining two building is maximum.
Note: The total water trapped between two buildings is gap between them (number of buildings removed) multiplied by height of the smaller building.
HINT - Two pointer approach: Take two pointers i and j pointing to the first and
the last building respectively and calculate the water that can be stored between
these two buildings. Now increment i if height[i] < height[j] else decrement j.
This is because the water that can be trapped is dependent on the height of the
small building and moving from the greater height building will just reduce the
 amount of water instead of
 maximizing it. In the end, return the maximum amount of water calculated so far.
    * */
    //Function to return the maximum water that can be stored.
    static int maxWater(int height[], int n)
    {
        int total = 0;
        int count = 0;
        int l = 0, r = n-1;
        while(r>l){
            int hmin = Integer.min(height[l],height[r]);
            int len = r-l-1;
            count = hmin*len;
            total = Integer.max(count,total);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return total;
        //Your code here
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int t = sc.nextInt();
        int n = sc.nextInt();
        ArrayInput ar = new ArrayInput();
        int height[] = ar.createArray(n);
        System.out.println(maxWater(height,n));
    }
}
/*6
2 1 3 4 6 5*/