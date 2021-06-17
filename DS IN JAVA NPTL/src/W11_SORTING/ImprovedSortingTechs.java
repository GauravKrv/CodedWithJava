package W11_SORTING;

public class ImprovedSortingTechs {
    /*
    1.HEAP SORT
    ==>More efficient - O(nlogn) in all cases
    ==>Concept of heap tree is reqd
Create heap
• Create the initial heap tree with n elements stored in the array A.
For i = n down to 1 do
Remove max
• Select the value in the root node (this is the maximum value in the heap). Swap the
values (that is A[1]) and value at the i-th location in A.
Rebuild heap
• Rebuild the heap tree for elements A[1, 2, …, i-1 ]

ALGORITHM - Heap sort
1. Read n elements and stored in the array A
2. ==CreateHeap(A) // Create the heap tree for the list of elements in A
3. For i = n down to 2 do // Repeat n-1 times
4. ==RemoveMax(B, i) // Remove the element at the root and swap it with the i-th
5. ==RebuildHeap(B, i-1) // Rebuild the heap with the elements B[1, 2, …, (i-1)], i>1
6. EndFor
7. Stop

ALGORITHM == Create heap
1. i = 1 // Initially, the heap tree (B) is empty and start with first element in A
2. While (i ≤ n) do // Repeat for all elements in the array A
3. x = A[i] // Select the i-th element from the list A
4. B[i] = x // Add the element at the i-th place in the array B
5. j = i // j is the current location of the element in B
6. While (j > 1) do // Continue until the root is checked
7. If B[j] > B[j/2] then // It violates the heap (max) property
8. temp = B[j] // Swap the elements
9. B[j] = B[j/2]
10. B[j/2] = temp
11. j = j/2 // Go to the parent node
12. Else
13. j = 1 // Satisfy heap property, terminates this inner loop
14. EndIf
15. EndWhile
i = i +1 // Select the next element from the input list
16. EndWhile
17. Stop

ALGORITHM == Remove Max
1. temp = B[i] // Swap the elements
2. B[i] = B[1]
3. B[1] = temp
4. Stop

1. If (i = 1) then
2. Exit // No rebuild with single element in the list
3. j = 1 // Else start with the root node
4. flag = TRUE // Rebuild is required
5. While (flag = TRUE) do
6. leftChild = 2*j, rightChild = 2*j+1
 Check if the right child is within the range of heap or not
// Note: If right child is within the range then also left child
7. If (rightChild i) then
8.  Compare whether left or right child will move to up or not
        9. If (B[j] B[leftChild]) AND B[leftChild] B[rightChild] then
// Parent and left violate heap property
10. Swap(B[j], B[leftChild]) // Swap parent and left child
11. j = leftChild // Move down to node at the next level
12. Else
13. If (B[j] B[rightChild]) AND B[rightChild] B[leftChild] then
// Parent and right violate heap property
14. Swap(B[j], B[rightChild]) // Swap parent and right child
15. j = rightChild // Move down to node at the next level
16. Else // Heap property is not violated
17. flag = FALSE
18. EndIf
19. EndIf
20. Else // Check if the left child is within the range of heap or not
21. If (leftChild ≤ i) then
22. If (B[j] B[leftChild]) then // Parent and left violate heap property
23. Swap(B[j], B[leftChild]) // Swap parent and left child
24. j = leftChild // Move down to node at the next level
25. Else // Heap property is not violated
26. flag = FALSE
27. EndIf
28. EndIf
29. EndIf
30. EndWhile




---------------------------------------------------------------------------
2.RADIX SORT
• A sorting technique which is based on radix or base of constituent elements in keys is called radix
sort. The radixes and bases in few important number systems are listed in the table given below.

Number system       Radix               Base    Example
Binary           0 and 1                 2          0100, 1101, 1111
Decimal     0,1,2,3,4,5,6,7,8,9         10      326, 12345, 1508
Alphabetic a, b,….,z A, B,….,Z          26   Ananya, McGraw
Alphanumeric A,…z, A….Z and 0…9         36  06IT6014 , 05CS5201



    * */
}

