package SEARCHING;

import java.util.Scanner;

/*
Q
Each book will be allocated to exactly one student.Each student has to be allocated at least one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)

HINT :
We need to think whether we can find how many number of students we need if we
fix that one student can read at most V number of pages. So, our problem
statement reduces to
 : Given fixed number of pages (V),  how many number of students we need?
* */
public class AllocateMinimumPages__ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            System.out.println(findPages(a, n, m));
        }
    }

    //Function to find minimum number of pages.
    public static int findPages(int[] a, int n, int m) {
        //Your code hereint
        if (n < m) return -1;
        int s = 0, mx = 0;
        for (int i = 0; i < n; i++) {
            s += a[i]; //getting count of total pages
            mx = Integer.max(mx, a[i]);//getting max page books from array
        }
        int l = mx, h = s, res = -1; //highest max allocated can be h[the sum] and lowest max allocated pages can be mx [the max element]
        while (h >= l) {
            int mid = (l + h) / 2;
            if (checkFeasible(a, n, m, mid)) { //if mid size can be feasible
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static boolean checkFeasible(int[] a, int n, int m, int mid) {
        int res = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + a[i] > mid) {
                res++;
                sum = a[i];

            } else {
                sum += a[i];
            }
        }
        return (res <= m);
    }

}
