package TreesNPTL;

public class TreesW6L2 {
    /*
        1.INTROD:: A tree is a finite set of one or more nodes such that:
• There is a specially designated node called the root.
• Remaining nodes are partitioned into n (n >0) disjoint sets T1, T2, . . ., Tn,
 where each Ti (i = 1, 2, . . ., n) is a tree; T1, T2, . . ., Tn are called sub trees of the root.

--->IN CSE Only TREE is there and in TREE only BINARY TREE IS USED

       2.TERMINOLOGIES:
       a)Node ==> This is the main component of any tree structure. The concept of node is same as
       used in linked list.Node of a tree stores the actual data and links to the other node.

        b)Parent ==> Parent of a node is the immediate predecessor of a node.

        c)Child ==> If the immediate predecessor of a node is the parent of the node then
         all immediate successors of a node are known as child. Child which is at the left
        side called the left child and that of at the right side is called the right child

        d)Link ==> This is a pointer to a node in a tree.
         ->Note that there may be more than two links of a node

        e)Root ==> This is a specially designated node which has no parent.

        f)Leaf ==> The node which is at the end and which does not have any child is
        called leaf node. Leaf node is also alternatively termed as terminal node.

        g)Sibling ==> The nodes which have the same parent are called siblings.

        h)Level ==>
        Level is the rank of the hierarchy and root node is termed as in level
        0. If a node is at level l then its child is at level l + 1 and parent is at
        level l – 1. This is true for all nodes except the root node. Level of
        the root node is zero.

        i)Height ==>
        Maximum number of nodes that is possible in a path starting from
        root node to a leaf node is called the height of a tree. For example,
        in the figure, the longest path is A – C – F – J – M and hence the
        height of this tree is 5. It can be easily obtained that h = level(max) + 1,
        where h is the height and lmax is the maximum level of the tre

        j)Degree ==> Maximum number of children that is possible for a node is known as
        the degree of a node.

        3.BINARY TREE:
        ==> A binary tree is a special form of a tree
        ==> A binary tree T is a finite set of nodes, such that  T is empty (called empty
        binary tree), or T contains a specially designated node called the root of T,
        and the remaining nodes of T form two disjoint binary trees T1 and T2 which are
        called left sub-tree and the right sub-trees, respectively.

        4.TYPES OF BTs
        a)Full Binary Trees =>• A binary tree is a full binary tree, if it contains maximum
        possible  number of nodes in all levels . A full BT can be called complete BT.

        b)Complete Binary Trees =>• A binary tree is said to be a complete binary tree,
         if all its levels, except possibly the LAST LEVEL, have the maximum number
         of possible nodes, and all the nodes at the last level appear as far left as
         possible.

        c)Skewed Binary Tree => • A binary tree is said to be a skewed binary tree, if
        all its levels, all nodes contain only one child .

        4.PROPERTIES OF BINARY TREES -- VVIP
        a) Maximum number of nodes possible in a binary tree of height h is (2^h+1) – 1.

        b) In any binary tree, maximum number of nodes on level l is 2^l , where l ≥ 0.

        c)Minimum number of nodes possible in a binary tree of height h is h.

        d)For any non-empty binary tree, if n is the number of nodes and e is the number
        of edges, then n = e + 1.

        e)For any non-empty binary tree T, if n0 is the number of leaf nodes (degree = 0) and
        n2 is the number of internal node (degree = 2), then n0 = n2 + 1.

        f)Height of a COMPLETE[not skew] binary tree with n number of nodes is [logb2(n+1)]

        5.REPRESENTATION OF A BINARY TREE:
        a)ARRAY REPRESENTATION:
        1.The root node is at index 1.
        2. For any node with index i, 1 < i ≤ n, (for some n):
        (a) PARENT(i) = For the node when i = 1, there is no parent.
        (b) LCHILD(i) = 2 * i , If 2 * i > n, then i has no left child.
        (c) RCHILD(i) = 2 * i + 1, If 2 * i + 1 > n, then i has no right child
        ==>Maximum and minimum size that an array may require to store a binary tree
        with n number of nodes are
            => Sizemax = 2n – 1  => required
            => Sizemin = {2^[logb2(n+1)]}  − 1

         b)LINKED LIST REPRESENTATION.
=======================================================================LECTURE 2 W6=======
         6.OPERATIONS ON BINARY TREES
         a)Traversal ==>
        • Traversal operation is a frequently used operation on a binary tree.
        • This operation is used to visit each node in the tree exactly once.
        • A full traversal on a binary tree gives a linear ordering of the data in the tree.
        • For an example, if the binary tree contains an arithmetic expression, then its
         traversal may give us the expression in infix notation, postfix notation or prefix notation

         ==>Different ways of traversal
         • Now a tree can be traversed in various ways. For a systematic traversal, it
         is better to visit each node (starting from the root) and its sub trees in the same fashion.
         • There are six such possible ways
            1. R Tl Tr [PreOrder-gives prefix]   4. Tr Tl R    ||Tl=left subtree  Tr = right subtree
            2. Tl R Tr [InOrder-gives infix]   5. Tr R Tl
            3. Tl Tr R [PostOrder-gives postfix]   6. R Tr T
         ==>Observation:
        • Visit 1 and Visit 4 are mirror symmetric.
        • Similarly, Visit 2 with Visit 5
        • Visit 3 with Visit 6.
        So, out of six possible traversals, only three are fundamental, they are categorized as given belo


         b)Insertion ==>
        • Insertion procedure, in fact, is a two-step process:
        1. To search for the existence of a node in the given binary tree after which
        an insertion to be made, and
        2. To establish a link for the new node.


         c)Deletion ==>
         • Like insertion procedure, deletion is also, a two-step process:
        1. to search for the existence of a node in the given binary tree, which node
         to be deleted
        2. to adjust the links among parent and child nodes of the deleted node.

         d)Merging ==>
         • Another fundamental operation that is possible is the merge operation.
        • This operation is applicable for trees which are represented using linked structure.
        • There are two ways that this operation can be carried out.
        1) Suppose, T1 and T2 are two binary
        trees. T2 can be merged with T1 if all the nodes from T2, one by one, is
        inserted into the binary tree T1 (insertion may be as internal node
        when it has to maintain certain property or may be as external nodes)

        2)• Another fundamental operation that is possible is the merge operation.
        • This operation is applicable for trees which are represented using linked structure.
        • There are two ways that this operation can be carried out:
        a)Suppose, T1 and T2 are two binary trees. T2 can be merged with T1 if
        all the nodes from T2, one by one, is inserted into the binary tree T1
        (insertion may be as internal node when it has to maintain certain
        property or may be as external nodes).

        b)Another way, when the entire tree T2 (or T1) is included as a sub-tree
        of T1 (or T2). For this, obviously we need that in either (or both)
        tree there must be at least one null sub-tree. We will consider in our
        subsequent discussion, this second case of merging.

        7.DIFFERENT TYPES OF BUNARY TREES
        There are several types of binary trees possible each with its own properties. Few
        important and frequently used trees are listed as below.
        1. Expression tree
        2. Binary search tree**
        3. Heap tree**
        4. Threaded binary tree
        5. Huffman tree**
        6. Height balanced tree (also known as AVL tree)**
        7. Red black tree
        8. Splay tree
        9. Decision tree

    * * */
}

