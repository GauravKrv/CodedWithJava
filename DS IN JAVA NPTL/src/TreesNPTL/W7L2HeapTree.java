package TreesNPTL;

public class W7L2HeapTree {
    /*
       1.DEFINITION OF HEAP TREE:
       A) A heap tree, say H, is a complete binary tree. H will be termed as heap tree, if it
    satisfies the following properties:
    • (i) For each node N in H, the value at N is greater than or equal to the value of
    each of the children of N.
    • (ii) Or in other words, N has the value which is greater than or equal to the value
    of every successor of N.
    • Such a heap tree is called max heap.

      B) A heap tree, say H, is a complete binary tree. H will be termed as heap tree, if it
    satisfies the following properties:
    • (i) For each node N in H, the value at N is less than or equal to the value of each
    of the children of N.
    • (ii) Or in other words, N has the value which is less than or equal to the value of
    every successor of N.
    • Such a heap tree is called min heap.

    2.STORING A HEAP: Array is best DS to store a heap.
    =>Logically it resembles a tree but physically it is stored as an aray
    =>There is no wastage of memory in array.
    =>If parent is at i=0  index then its left child will be at 2i + 1 and
    right child at 2i+2 location

    3.CREATING A HEAP : We have to insert one node  and have to check whether it satisfies heap
    property or not =>
    Case 1  : Leaf insertion : If satis fies then ok
    else have to swap to above node This is called re heaping

    2.DELETION FROM A HEAP :
    ==>Deleetion of root from heap :
    • Any node can be deleted from a heap tree. But from the application
    point of view, deleting the root node has some special importance.
    • Copy the root node into a temporary storage, say ITEM.
    • Replace the root node by the last node in the heap tree. Then reheap the
    tree as stated below:
    • Let newly modified root node be the current node. Compare its value with the
    value of its two child. Let X be the child whose value is the largest. Interchange
    the value of X with the value of the current node.
    • Make X as the current node.
    • Continue reheap

    ALGORITHM :
    Algorithm DeleteMaxHeap
1. If (N = 0) then
2. Print “Heap tree is exhausted: Deletion is not possible”
3. Exit
4. EndIf
5. ITEM = A[1] // Value at the root node under deletion
6. A[1] = A[N] // Replace the value at root by its counterpart at last node on last level
7. N = N – 1 // Size of the heap tree is reduced by 1
8. flag = FALSE, i = 1
9. While(flag = FALSE) and (i < N) do // Rebuild the heap tree
10. lchild = 2 * i, rchild = 2 * i+1 // Addresses of left and right child of the current node
11. If (lchild £ N) then
12. x = A[lchild]
13. Else
14. x = – ¥
15. EndIf
16. If (rchild £ N) then
17. y = A[rchild]
18. Else
19. y = – ¥
20. EndIf
NPTEL
Continue …
05.08.09 IT 60101: Lecture #6 21
Algorithm: Deletion from max heap
21. If (A[i] > x) and (A[i] > y) then // If parent is larger than its child
22. flag = TRUE // Reheap is over
23. Else // Any child may have large value
24. If (x > y) and (A[i] < x) // If left child is larger than right child
25. Swap(A[i], A[lchild]) // Interchange the data between parent and left child
26. i = lchild // Left child becomes the current node
27. Else
28. If (y > x) and (A[i] < y) // If right child is larger than left child
29. Swap(A[i], A[rchild]) //Interchange the data between parent and right child
30. i = rchild // Right child becomes the current node
31. EndIf
32. EndIf
33. EndIf
34. EndWhile
35. S


4.MERGING TWO HEAPS
Consider, two heap trees H1 and H2.
• Merging the tree H2 with H1 means to include all the nodes from H2 to H1. H2 may be min
heap or max heap and the resultant tree will be min heap if H1 is min heap else it will be
max heap.
Merging operation consists of two steps:
• Continue steps 1 and 2 while H2 is not empty:
1. Delete the root node, say x, from H2.
2. Insert the node x into H1 satisfying the property of H1.

    5.APPLICATIONS OF HEAP :
    1)SORTING ==>
    • Step 1:
Build a heap tree with the given set of data.
    • Step 2:
(a) Delete the root node from the heap.
(b) Rebuild the heap after the deletion.As we did during deletion by replacing it with last elem
thus we can do it by using the single array =>Smallest elem of Lchild or largest elem of
Rchild will be used to replace with root while deletion
(c) Place the deleted node in the output.
    • Step 3:
Continue Step 2 until the heap tree is empty

    2)PRIORITY QUEUE

    Consider the following processes, their arrival with their priorities:
    Process P1 P2 P3 P4 P5 P6 P7 P8 P9 P10
    Priority 5 4 3 4 5 5 3 2 1 5

    Ordering of processing should be:
    P1 P5 P6 P10 P2 P4 P3 P7 P8 P9


    * * */
}
