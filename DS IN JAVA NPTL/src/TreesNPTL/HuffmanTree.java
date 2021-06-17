package TreesNPTL;

public class HuffmanTree {
    /*
    WEIGHTED BINARY TREE :
    1.TERMINOLOGIES:
    =>Internal node: A node with one or more children is called an internal node.

    =?External node: A node with zero children is called an external nod

    =>Path length: Path length of a node in a tree is defined as
    the number of edges that has to be traversed from the node to the root node.

    =>Internal path length: Internal path length (let it be denoted as I) of a binary
    tree can be defined analogously as the sum of path lengths of all internal nodes
     in the tree.
    N1 N2 N3 N4 N5 N6 N7 N8 N9
    I = 0 + 1 + 2 + 1 + 2 + 3 + 2 + 3 + 4 = 18

    =>External path length: External path length (let it be denoted as
    E) of a binary tree is defined as the sum of all path lengths,
    summed over each path from the root node of the tree to an external node

    =>Relation between Int & Ext PL:
    In a binary tree with n internal nodes, if I denotes the internal path length,
    then external path length
            E = I + 2n.
    =>Extended BT : All the single child parent is filled with another dujmmy child

    2.DEFINITION OF WEIFGHTED BT :
    =>Suppose, all internal nodes have unit values but each of the external nodes are assigned a
    (non-negative) number called weighT

    =>The external path length with these weights are called external weighted path length (or, simply
weighted path length) and the corresponding binary tree is termed as extended weighted binary
tree (or, simply weighted binary tree).
  =>if Wi is a weight of an external node ni and its path length is Li then, weighted path length, P is:
        P = Summ(i=1 ->n){ Wi*Li}

    E.x:Assume A tree is given and its leaf nodes are assgned with weights and path lengths =:
    P = W1L1+ W2L2 + W3L3 + W4L4 + W5L5 + W6L6 + W7L7
= 2 × 2 + 5 × 2 + 3 × 4 + 4 × 4 + 1 × 3 + 7 × 3 + 6 × 3
= 4 + 10 + 12 + 16 + 3 + 21 + 18
= 84

    HUFFMAN ALGORITHM
    1.PROBLEM:Building a weighted BT with minimum weighted path length
    ==>Given a set of weights (for the external nodes), how a weighted binary tree can
    be constructed, so that it has minimum weighted path length\

    2.HUFFMAN ALGORITHM:
    • An elegant solution to the problem of finding a binary tree with minimum weighted
    external path length was given by D. Huffman.
    • The tree that can be constructed with the Huffman’s algorithm is guaranteed to be a
    minimum weighted binary tree and to honour the inventor, such trees are alternatively
     termed as Huffman tree.
    • The algorithm is an iterative method with greedy strategy.

    3.ALGORITHM
    Input: n weights W1, W2, . . ., Wn.
    Steps:
    1. Sort the weights in ascending order.
    2. Obtain a sub-tree with two minimum weights as the weights of external nodes.
    3. Include the weighted path length of the sub-tree so obtained into the list of weights.
    4. Repeat the procedure until the list contains single weight.

    E.x:
    1 2 3 4 5 7 => Leaf node weights => 1+2  , 1+2+3, 1+2+3+4, 1+2+3+4+5, 1+2+3+4+5+7
    P = 22 + 9 + 13 + 6 + 3 = 54 =>Total weighted path length with Huffman Algo

==============================Huffman algorithm
1. For i = 1 to N do // Read the external nodes and initialize the PARRAY
2. ptr = GetNode(NODE)
3. ptr→WEIGHT = W[i] // To read the weight for the external node
4. ptr→LCHILD = NULL // Link fields of external nodes are empty
5. ptr→RCHILD = NULL
6. PARRAY[i] = ptr // Store the node into the PARRAY
7. EndFor
8. i = 1
9. While (i < N) do
10. Sort_PARRAY(i, N) // Sort the weights from i to N in ascending order
11. ptr = GetNode(NODE) // Get a node for internal node
12. ptr→DATA = NULL
13. ptr→LCHILD = PARRAY[i] // Include the lowest weight as the left sub-tree
14. ptr→RCHILD = ptr→PARRAY[i + 1] // Include the second lowest weight as the right sub-tree
15. ptr→WEIGHT = (ptr→LCHILD) →WEIGHT + (ptr→RCHILD) →WEIGHT
// Path length of sub-tree
16. PARRAYE[i + 1] = ptr // Store the pointer to the sub-trees into the list of weights
17. i = i + 1
18. EndWhile
19. ROOT = PARRAY[N] // Root of the Huffman tree
20. Stop
=========================================



















    * * */
}
