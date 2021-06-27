package ARRAYS;

public class EquibliriumPoint {
/*O(N) - WORKS
Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array.
Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
* */
  static  int equilibriumPoint(long arr[], int n) {

        if(n == 1) return 1;
         long right_sum = 0, left_sum = 0;

        // Computing right_sum
        for (int i = 1; i < n; i++)
            right_sum += arr[i];

        // Checking the point of partition
        // i.e. left_Sum == right_sum
        for (int i = 0, j = 1; j < n; i++, j++) {
            right_sum -= arr[j];
            left_sum += arr[i];

            if (left_sum == right_sum)
                return j+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        long A[] = {1,3,5,2,2};
        int equilib = equilibriumPoint(A,5);
        System.out.println(equilib);
    }
}
