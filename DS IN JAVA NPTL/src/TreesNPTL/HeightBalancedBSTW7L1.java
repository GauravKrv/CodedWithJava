package TreesNPTL;

public class HeightBalancedBSTW7L1 {
    /*
    1.ISSUE WITH BINARY SEARCH TREE==>
    • Average search time in a binary search tree:
    Time = T1 + T2 + ... Tn / n

    Tn = Number of comparisons for the n-th element
    n = Total number of elements in the binary search tree

    ==>BST has some avg search time value .We have to optimise BST so that the avg search
    time is minimum.A binary search tree should be with a minimum value of average search t.
    E.g : a skewed BST is having the max search time.

    2.HOW TO FIND THE BST WITH A INIMUM VALUE OF AVG SEARCH TIME ==>
    Solution =>
    • Height balanced binary search tree
    • Also called AVL tree (Adelson-Velsky and Landis)
    • Concept of balance factor of a node
    BAL FACTOR : bf = Height of the left sub-tree (hL) – Height of the right sub-tree (hR)

    3.HEIGHT BALANCED BST ==>
    A binary search tree is said to be height balanced binary search tree
    if all its nodes have a balance factor of 1, 0 or –1.
    =>That is, for all nodes |bf| = |hL – hR| ≤ 1

    4.STEPS TO MAKE A BST HEIGHT BALANCED
    Steps ==>
    • Insert node into a binary search tree
    • Compute the balance factors
    • Decide the pivot node ->noed with bf other than 1, 0 or –1,nearer to the inserted node
    • Balance the unbalance tree

    6.AVL ROTATIONS:
    • AVL Rotations • G.M. Adelson-Velskii and E.M. Lendis (1962)
• Case 1: Left-to-Left rotation • pivot -> left-sub tree -> left child
• Case 2: Right-to-Right rotation • pivot -> right-sub tree -> right child

• Case 3: Left-to-Right rotation • pivot ->left-sub tree -> right child
==> Also called double rotation
• Rotation 1 (Right-to-Left)
    • Left sub-tree (BL) of the right child (B) of the left child of the pivot node (P)
       beco    mes the right sub-tree of the left child (A).
    • Left child (A) of the pivot node (P) becomes the left child of B.
• Rotation 2 (Left-to-Right)
    • Right sub-tree (BR) of the right child (B) of the left child (A) of the PIVOT node
    (P) becomes the left sub-tree of P.
    • P becomes the right child of B

• Case 4: Right-to-Left rotation • pivot ->right-sub tree -> left child
==> It is also another double rotation
• Rotation 1(Left-to-Right)
    • Right sub-tree (BR) of the left child (B) of the right child (A) of the pivot node
    (P) becomes the left sub-tree of A.
    • Right child (A) of the pivot node (P) becomes the right child of B.
• Rotation 2 (Right-to-Left)
    • Left sub-tree (BL) of the right child (B) of the right child (A) of the pivot rode
    (P) becomes the right sub-tree of P.
    • P becomes the left child of B


    7.MAX HEIGHT POSSIBLE IN AN AVL TREE :
    • Maximum height possible in an AVL tree with n number of
    nodes is given by =>hmax = 1.44log2 n
For the proof of this property see the book -> Classic Data Structures Chapter 7 PHI, 2nd Edn., 30th Reprint


















    * * */
}
