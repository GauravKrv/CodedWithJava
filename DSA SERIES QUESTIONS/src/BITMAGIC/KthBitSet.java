package BITMAGIC;

public class KthBitSet {
    static void isKthBitSet(int n,
                            int k)
    {
        if (((n >> (k - 1)) & 1) == 1)  //if (((n >> (k - 1)) % 2 ) != 0)
            System.out.println("SET");
        else
            System.out.println("NOT SET");
    }

    // Driver code
    public static void main (String[] args)
    {
        int n = 5, k = 1;
        isKthBitSet(n, k);
    }
}
