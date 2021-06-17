package W11_SORTING;

public class AdvancedSortingAlgo {
    /*CONCEPT OF DIVIDE AND CONQUER
    --Here we divide the problem into smaller parts, e.g if list is very large then we divide
    the list into smaller list

    MERGESORT
    • Divide
Partition the list midway, that is, at [[l+r]/2] into two sub lists with n/2 elements
in each if n is even o n/2 r and [n/2]-1 elements if n is even.
• Conquer
Sort the two lists recursively using the merge sort.
• Combine
Merge the sorted sub lists to obtain the sorted output.

Tn = D[n] + Tn/2 + T n/2 + Cn = T[n/2]

ALGORITH ==>
1. i = 1, j = 1, k = 1 // Three pointers, initially point to first locations
2. While(i ≤ n1 and j ≤ n2) do
3. If (A[i] ≤ B[j]) then
4. C[k] = A[i]
5. i = i+1, k = k+1
6. Else // A[i] > B[j]
7. C[k] = B[j]
8. j = j+1, k = k+1
9. EndIf
10. EndWhile
11. If (i > n1) then // A is fully covered
12. For p = j to n2 do // Move the rest of the elements in B to C
13. C[k] = B[p]
14. p = p+1, k = k+1
15. EndFor
16. Else
17. If (j > n2 ) then // B is fully covered
18. For p = i to n1 do
19. C[k] = A[l] // Move the rest of the elements in A to C
20. p = p + 1, k = k + 1
21. EndFor
22. EndIf
23. EndIf
24. Stop

T(n) = O(nlogb2n)

-------------------------------------------------------------------------------
QUICKSORT

• Divide
Partition the list A[1, 2, …, n] into two (possibly empty) sub lists A[1, .... p-1] (left sub
list) and A[p+1, ..., n] (right sub list) such that each elements in the sub list A[1, ..., p1]
is less than or equal to A[p] and each element in the sub list A[p+1, ..., n] is greater
than A[p]. In other words, satisfying the above mentioned constraint a partition
method should compute an index p, which in fact divides the list into two sub lists.

• Conquer
Sort the two sub lists A[1, .... p-1] and A[p+1, ..., n] recursively, as if each sub list is a
list to be sorted and following the same divide-and-conquer strategy until the sub lists
contain either zero or one element. This is the desirable minimum size of a sub list to
stop further recursion.

• Combine
Since the sub lists are sorted in place, no work is needed to combine them. That is,
the task combine in the quick sort is implicit.

Why quickSort over merge?

    * */
}
