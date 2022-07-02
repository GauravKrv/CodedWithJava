package DP;

public class LongestIncreasingSubsequence {
    //12 JUN 22 - STRIVER
    static int lisrecursion(int[] arr, int i,int maxtillnow, int len){
        if (i==-1) return len;
        if (arr[i]<maxtillnow){
            return lisrecursion(arr,i-1,arr[i],len+1);
        }
        return Math.max(lisrecursion(arr,i-1,maxtillnow,len),lisrecursion(arr,i-1,arr[i],1));

    }



//LIS + LIS MAX
    static int lis(int arr[],int i,int curr){
        if(i==arr.length)
        {
          return 0;
        }

        if (arr[i]>=curr)  return 1+lis(arr,i+1,arr[i]);
        else{
            return lis(arr,i+1,curr);
        }
    }

    static int lismax(int arr[],int n){
        int max = 1;
        for (int j = 0; j < n; j++) {
            max = Integer.max(max,lis(arr,j,arr[j]));
        }
        return max;
    }

    //O(NLOGN)
    static int ceilIdx(int tail[], int l, int r, int key)
    {
        while (r > l) {
            int m = l + (r - l) / 2;
            if (tail[m] >= key)
                r = m;
            else
                l = m+1;
        }

        return r;
    }

    static int LIS(int arr[], int n)
    {
        int[] tail = new int[n];
        int len =1;

        tail[0] = arr[0];

        for (int i = 1; i < n; i++) {

            if(arr[i] > tail[len - 1])
            {
                tail[len] = arr[i];
                len++;
            }
            else{
                int c = ceilIdx(tail, 0, len - 1, arr[i]);

                tail[c] = arr[i];
            }
        }

        return len;
    }


    public static void main(String[] args) {
        int[] arr = {3,1,2,3,8,10,1,2,3,4,6,3};

       // int[] arr = {5,4,3,2,1};
        //int[] arr = {1,2,3,4,6,7};



        System.out.println(lismax(arr,arr.length));// --> uses lis
        System.out.println(otherDp(arr));
        System.out.println(lisrecursion(arr,arr.length-1,Integer.MAX_VALUE,0));

    }

    //O(N*N) ---WORKSSSS -- CAN BE CHANGED FOR NON DEC, DEC ETC
    static int otherDp(int[] arr){
        int[] lis = new int[arr.length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]>arr[j]){
                    lis[i] = Integer.max(lis[i],lis[j]+1);
                    max = Integer.max(lis[i],max);
                }
            }
        }

        return max+1;


    }
}
