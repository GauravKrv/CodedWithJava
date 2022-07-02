package BITMAGIC;

public class KthBitSet {
    //CHECK IF KTH BIT IS SET OR NOT - IF NOT -> SET IT
    static void isKthBitSet(int n,
                            int k)
    {
        if (((n >> (k - 1)) & 1) == 1)  //if (((n >> (k - 1)) % 2 ) != 0) => here we shift the k-1 tyms the n and => if that is =1 => kth bit is set

            System.out.println("SET");
        else
            setKthBitSet(n,k);
    }


    static void setKthBitSet(int n,
                            int k)
    {
        System.out.println("Setting kth bit : ");
        n = n | ((n >> (k - 1)) | 1) ;
        System.out.println(n);

    }

    static int unsetKthBitSet(int n,
                             int k)
    {
        System.out.println("Unsetting kth bit : ");
        int neg = (int) Math.pow(2,k-1);
        neg = ~neg;

        System.out.println(n&neg);
        return n&neg;

    }

    static void otherwaysetting(int n,int k){
        System.out.println("Setting: ");
        int i = 1<<(k-1);
        n = n|i;
        System.out.println(n);
    }

    static void josephus(int x){
        int k = leftmost(x);
        int n = x;
        int ans = unsetKthBitSet(n,k);
        ans = ans<<1;
        ans = ans|1;
        System.out.println("josephus = ");
        System.out.println(ans);

    }

    private static int leftmost(int x) {
        int count = 0;//10010
        while (x>0){
            x=x>>1;
            count++;
        }
        return count;
    }


    // Driver code
    public static void main (String[] args)
    {
        int n = 5, k = 1;
//        isKthBitSet(n, k);
//        unsetKthBitSet(n,k);
//        otherwaysetting(n,k);

        josephus(16);
    }
}
