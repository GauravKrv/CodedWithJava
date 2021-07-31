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
    static public int[] twoOddNum(int arr[], int size)
    {
        int xor2 = arr[0];

        /* Will have only single set bit of xor2 */
        int set_bit_no;
        int i;
        int n = size - 2;
        int x = 0, y = 0;

      /* Get the xor of all elements in arr[].
         The xor will basically be xor of two
         odd occurring elements */
        for(i = 1; i < size; i++)
            xor2 = xor2 ^ arr[i];

      /* Get one set bit in the xor2. We get
         rightmost set bit in the following
         line as it is easy to get */
        set_bit_no = xor2 & ~(xor2-1); //this number will give a bit such that the bit is set in one number and unset in another

      /* Now divide elements in two sets:
            1) The elements having the
               corresponding bit as 1.
            2) The elements having the
               corresponding bit as 0.  */
        for(i = 0; i < size; i++)
        {
         /* XOR of first set is finally going
            to hold one odd occurring number x */
            if((arr[i] & set_bit_no)>0){
                System.out.println("G1 = "+arr[i]+" ^"+set_bit_no);
                x = x ^ arr[i];
            }


         /* XOR of second set is finally going
            to hold the other odd occurring number y */
            else{
                System.out.println("G2 = "+arr[i]+" ^"+set_bit_no);
                y = y ^ arr[i];
            }

        }
        if(x<y){
            int temp = y;
            y = x;
            x=temp;
        }
        int[] ar = {x,y};
        return ar;
    }

    public static void main(String[] args) {
        int n = (new Scanner(System.in)).nextInt();// anonymous object creation
        //Scanner sc = new Scanner(System.in);

       ArrayInput arrayInput = new ArrayInput();
        int[] arr = arrayInput.createArray(n);

      // arrayInput.printArray(arr,n);
       twoOddNum(arr,n);

    }
}
