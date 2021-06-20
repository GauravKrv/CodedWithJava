package BITMAGIC;

public class CountSetBits {
    static int []table = new int[256];

    // recursive function to count set bits
    public static void initialize() {

        // To initially generate the table algorithmically:
        table[0] = 0;
        for (int i = 0; i < 256; i++)
        {
            table[i] = (i & 1) + table[i / 2];
        }
    }
// LOOKUP TABLE METHOD -- TAKES O(1) to count set bits
    public static int countSetBits(int n)
    {
        return table[n & 0xff] +
                table[(n >> 8) & 0xff] +
                table[(n >> 16) & 0xff] +
                table[n >> 24];



    }

    /* Function to get no of set bits in binary representation-- TAKES O(count) --BRIAN KERNINGHAM ALGO*/
    static int countSetBits2(int n)
    {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }


    // Driver function
    public static void main(String[] args) {
        initialize();
        int n = 15;
        System.out.println(countSetBits2(n));
    }

}
