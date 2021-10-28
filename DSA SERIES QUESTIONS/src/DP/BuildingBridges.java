package DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//O (N^2) SINCE I HAVE USED THE DP METHOD OF LIS AN NOT THE BNARY SEARCH METHODCRFFFF
public class BuildingBridges {
    static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static void compare(Pair[] arr,int n){

        // Comparator to sort the pair according to second element
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p1.x - p2.x;
            }
        });

    }

    static int buildingBridges(Pair[] arr){
        compare(arr,arr.length);

        return lisDP(arr);

    }

    static int lisDP(Pair[] arr){
        int[] lis = new int[arr.length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].y>arr[j].y){
                    lis[i] = Integer.max(lis[i],lis[j]+1);
                    max = Integer.max(lis[i],max);
                }
            }
        }

        return max+1;


    }

    public static void main(String[] args) {
        int n = 8;

        // Array of Pair
        Pair arr[] = new Pair[n];

        arr[0] = new Pair(8,1);
        arr[1] = new Pair(1, 2);
        arr[2] = new Pair(4,3);
        arr[3] = new Pair(3,4);
        arr[4] = new Pair(2,6);
        arr[5] = new Pair(6,7);
        arr[6] = new Pair(7,8);
        arr[7] = new Pair(5,5);

        int result = buildingBridges(arr);
        System.out.println(result);
    }
}

// Java code to sort the array
// according to second element
// User defined Pair class
class Pair {
    int x;
    int y;

    // Constructor
    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

// class to define user defined conparator
class Compare {

    static void compare(Pair arr[], int n)
    {
        // Comparator to sort the pair according to second element
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p1.x - p2.x;
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].x + " " + arr[i].y + " ");
        }
        System.out.println();
    }
}

// Driver class
class GFG {

    // Driver code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // length of array
        int n = 5;

        // Array of Pair
        Pair arr[] = new Pair[n];

        arr[0] = new Pair(10, 20);
        arr[1] = new Pair(1, 2);
        arr[2] = new Pair(3, 1);
        arr[3] = new Pair(10, 8);
        arr[4] = new Pair(4, 3);

        Compare obj = new Compare();

        obj.compare(arr, n);
    }
}

