package BITMAGIC;

import ARRAYS.ArrayInput;

import java.util.Scanner;


public class OddOccuringsInArray {
  //  O(N)
    static int findOdd(int[] arr, int n)
    {
        int res = 0;

        for(int i = 0; i < n; i++)
        {
            res = res ^ arr[i];
        }

        return res;
    }
//O(N) ****
    static void twoOddAppearing(int[] arr, int n)
    {
        int xor = 0, res1 = 0, res2 = 0;

        for (int i = 0; i < n; i++)
            xor = xor ^ arr[i];


        int sn = xor & (-xor);// OR int sn = xor & (~(xor - 1));



        for (int i = 0; i < n; i++)
        {
            if ((arr[i] & sn) != 0)
                res1 = res1 ^ arr[i];
            else
                res2 = res2 ^ arr[i];
        }


        System.out.println( res1 + " " + res2);

    }

    public static void main(String[] args) {
        int n = (new Scanner(System.in)).nextInt();// anonymous object creation
        //Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
       ArrayInput arrayInput = new ArrayInput();
       arrayInput.createArray(arr,n);

      // arrayInput.printArray(arr,n);
       twoOddAppearing(arr,n);

    }
}
