package HASHING;

import java.util.*;

/*QUESTION
Given an array of n elements, the task is to find the greatest number such that it is
product of two elements of given array. If no such element exists, print -1. Elements are within the range of 1 to 10^5.

TAKEAWAYS [HashMap Approach]: Here we use HashMap to store elements of the array,and then
 we can store the array elements in a HashMap
And we can get the product result for each case in O(1) T.C
* */
public class PairWithGrtstProductArray {
    // Java program to find the largest product number

        // Function to find greatest number
        static int findGreatest(int arr[], int n)
        {
            // Store occurrences of all  elements in hash array
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++)
            {
                if (m.containsKey(arr[i]))
                {
                    m.put(arr[i], m.get(arr[i]) + 1);
                }
                else
                {
                    m.put(arr[i], m.get(arr[i]));
                }
            }
             // m[arr[i]]++;
            // Sort the array and traverse
            // all elements from end.
            Arrays.sort(arr);

            for (int i = n - 1; i > 1; i--)
            {
                // For every element, check if there is another
                // element which divides it.
                for (int j = 0; j < i &&
                        arr[j] <= Math.sqrt(arr[i]); j++)
                {
                    if (arr[i] % arr[j] == 0)
                    {
                        int result = arr[i] / arr[j];

                        // Check if the result value exists in array
                        // or not if yes the return arr[i]
                        if (result != arr[j] &&
                                m.get(result) == null|| m.get(result) > 0)
                        {
                            return arr[i];
                        }

                        // To handle the case like arr[i] = 4
                        // and arr[j] = 2
                        else if (result == arr[j] && m.get(result) > 1)
                        {
                            return arr[i];
                        }
                    }
                }
            }
            return -1;
        }

        // Driver code
        public static void main(String[] args)
        {
            int arr[] = {17, 2, 1, 15, 30};
            int n = arr.length;
            System.out.println(findGreatest(arr, n));
        }
    }

// This code is contributed by PrinciRaj1992
/*OUTPUTS :
Input :  arr[] = {10, 3, 5, 30, 35}
Output:  30
Explanation: 30 is the product of 10 and 3.

Input :  arr[] = {2, 5, 7, 8}
Output:  -1
Explanation: Since, no such element exists.

Input :  arr[] = {10, 2, 4, 30, 35}
Output:  -1

Input :  arr[] = {10, 2, 2, 4, 30, 35}
Output:  4

Input  : arr[] = {17, 2, 1, 35, 30}
Output : 35
* */

