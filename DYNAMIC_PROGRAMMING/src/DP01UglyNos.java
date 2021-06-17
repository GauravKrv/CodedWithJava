public class DP01UglyNos {
    static int getNthUglyNo(int n){
        int[] uglyNos = new int[n];
        int i2=0,i3=0,i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;

        int next_multiple_of_5 = 5;
        int nextUglyNo = 1;

        uglyNos[0] = 1;
        for (int i=1;i<n;i++){

             nextUglyNo = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));
             uglyNos[i] = nextUglyNo;
            System.out.print(nextUglyNo + " ");

            if (nextUglyNo==next_multiple_of_2){
                i2 = i2+1;
                next_multiple_of_2 = uglyNos[i2]*2;
        }
            if (nextUglyNo==next_multiple_of_3){
                i3 = i3 + 1;
                next_multiple_of_3 = uglyNos[i3]*3;
            }
            if (nextUglyNo==next_multiple_of_5){
                i5 = i5+1;
                next_multiple_of_5 = uglyNos[i5]*5;
            }
        }

        return nextUglyNo;
    }

    public static void main(String[] args) {
        int n = 150;
        System.out.println(getNthUglyNo(n));
        System.out.println(getNthUglyNo2(n));

    }

    //GFG
    static int getNthUglyNo2(int n)
    {
        // To store ugly numbers
        int ugly[] = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;

        for (int i = 1; i < n; i++)
        {
            next_ugly_no
                    = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2)
            {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3)
            {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5)
            {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        }

        // End of for loop (i=1; i<n; i++)
        return next_ugly_no;
    }
}
/*
Time Complexity: O(n)
Auxiliary Space: O(n)
* */