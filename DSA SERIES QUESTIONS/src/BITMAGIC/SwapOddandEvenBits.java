package BITMAGIC;

public class SwapOddandEvenBits {

    //OPTIMISED = O(1)
    //Function to swap odd and even bits.
    public static int swapBits(int n)
    {
        //nice
        int even = (n&0xaaaaaaaa)>>1;
        int odd = (n&0x55555555)<<1;
        return even | odd;
        // Your code
    }
}
/*
Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, if the given number is 23 (00010111), it should be converted to 43(00101011). Here, every even position bit is swapped with adjacent bit on the right side(even position bits are highlighted in the binary representation of 23), and every odd position bit is swapped with an adjacent on the left side.

Example 1:

Input: N = 23
Output: 43
Explanation:
Binary representation of the given number
is 00010111 after swapping
00101011 = 43 in decimal.
* */