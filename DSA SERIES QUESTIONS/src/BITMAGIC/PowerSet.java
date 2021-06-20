package BITMAGIC;

public class PowerSet {
    //T.C = O(2^n * n)
    static void printPowerSet(String str)
    {
        int n = str.length();

        int powSize = (int)Math.pow(2, n);

        for(int counter = 0; counter < powSize; counter++)
        {
            for(int j = 0; j < n; j++)
            {
                if((counter & (1 << j)) != 0) // eazy just look here
                    System.out.print(str.charAt(j));
            }

            System.out.println();
        }
    }



    public static void main(String[] args)
    {
        String s = "abc";

        printPowerSet(s);
    }
}
