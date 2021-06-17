package ARRAYS;

public class RotateArray {
    //Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
        int temp=0;
        while(d!=0)
        {
            temp =arr[0];
            for(int i=0;i<n-1;i++)
                arr[i]=arr[i+1];


            arr[n-1]=temp;
            d--;
        }

    }

    static void rotateArr2(int arr[], int d, int n) {
        int[] arr2 = new int[d];
        for (int i = 0; i < d; i++) {
            arr2[i] = arr[i];
        }
        int j = 0;
        for (int i = 0; i < n; i++) {

            if (i < n - d) {
                arr[i] = arr[i + d];
            } else {
                arr[i] = arr2[j++];
            }

        }
    }
//O(N) S(1) Algo--Juggling Algo to rotate array
    void leftRotate(int arr[], int d, int n)
    {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /*UTILITY FUNCTIONS*/

    /* function to print an array */
    void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    /*Fuction to get gcd of a and b*/
    int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public static void main(String[] args) {
        int n = 6;
        int d = 2;
        int[] arr ={1,2,3,4,5,6};
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        rotateArr(arr,d,n);

        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}
