package BITMAGIC;

import java.util.Scanner;

public class CountSetBits {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println( s.countSetBits(n));


    }
}

class Solution{

    //Function to return sum of count of set bits in the integers from 1 to n.
    static int[] table = new int[256];

    static void initialising(){
        table[0] = 0;
        for(int i=1;i<256;i++){
            table[i] = (i&1)+table[i/2];
        }

    }

    public int countSetBits(int n){
        initialising();
        int res = 0;

        for(int i=1;i<=n;i++){
            int n2 = i;
            while(n2>0){
                res = res + table[n2&0xff];
                n2 = n2>>8;
            }
        }
        return res;
        // Your code here

    }

}
