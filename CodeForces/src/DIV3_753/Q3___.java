package DIV3_753;

import java.util.Arrays;

public class Q3___ extends CodeForces{
    //NOT WORKS -- 40 MINS GIVEN
    //wors -- 15mins given more
    //tle on test 5 i.e when aray size is 100000 but ran on 200000 sized => some irregularity is there in answer
    static  int curr = 0;
    static int min_extract(int[] arr, int n){
        int min = arr[n-1] - curr;

        curr += min;

        return min;
    }

    static int solution(int[] arr,int n){
        int max = Integer.MIN_VALUE;
        if (n==1) return arr[0];

        while (n>1){
            max = Integer.max(max, min_extract(arr,n));
            n--;
        }
        return Math.max(max,arr[0]-curr);

    }

    public static void reverse(int[] array)
    {

        int n = array.length;

        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int t = I();
        while (t-->0){
            int n = I();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = I();
            }
            Arrays.sort(arr);
            reverse(arr);
            curr = 0;
            System.out.println(solution(arr,n));
        }
    }
}
