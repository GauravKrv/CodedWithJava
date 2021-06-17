package TreesNPTL;

public class BstW6L4 {
    /*
    1.DEFINITION BST ==> It is called BST becoz it has immense application for searching
     purposes & is called sorted tree as its traversal gives a sorted output.
    ==> A binary tree T is termed as binary search tree (or binary sorted
    tree) if each node N of T satisfies the following property:
        => The value at N is greater than every value in the left sub-tree of N and is
        less than every value in the right sub-tree of N.

    2.OPERATIONS ON BST:
        a) SEARCHING for a data ==>
        • Searching for a data in a binary search tree is much faster than in arrays
        or linked lists.
        • This is why, in the applications where frequent searching operations are to be
        performed, this data structure is used to store data
        SEARCHING ALGO -->
1. ptr = ROOT, flag = FALSE // Start from root
2. While (ptr ≠ NULL) and (flag = FALSE) do
3. Case: ITEM < ptr→DATA // Go to the left sub-tree
4. ptr = ptr→LCHILD
5. Case: ptr→DATA = ITEM // Search is successful
6. flag = TRUE
7. Case: ITEM > ptr→ DATA // Go to the right sub-tree
8. ptr = ptr→RCHILD
9. EndCase
10. EndWhile
11. If (flag = TRUE) then // Search is successful
12. Print “ITEM has found at the node”, ptr
13. Else
14. Print “ITEM does not exist: Search is unsuccessful”
15. EndIf
16. Stop


        b) INSERTING any data into it ==>
        • Insertion operation on a binary search tree is conceptually very simple.
        • It is in fact, one step more than the searching operation.
        • To insert a node with data, say ITEM, into a tree, the tree is to be searched
        starting from the root node.
        • If ITEM is found, do nothing; otherwise, ITEM is to be inserted at the dead end
        where search halts
        • Search for the ITEM starting from the root node.
        • If ITEM is found, do nothing; otherwise, ITEM is to be inserted at the dead end
         where search halts
         ALGO -->
         Algorithm InsertBST(ROOT, ITEM)
1. ptr = ROOT, flag = FALSE // Start from root node
2. While (ptr ¹ NULL) and (flag = FALSE) do
3. Case: ITEM < ptr→DATA // Go to the left sub-tree
4. ptr1 = ptr
5. ptr = ptr→LCHILD
6. Case: ITEM > ptr→DATA // Go to the right sub-tree
7. ptr1 = ptr
8. ptr = ptr→RCHILD
9. Case: ptr→DATA = ITEM // Node exists
10. flag = TRUE
11. Print “ITEM already exists”
12. Exit // Quit the execution
13. EndCase
14. EndWhile
16. If (ptr = NULL) then // Insert when search halts at dead end
17. new = GetNode(NODE)
18. new→DATA = ITEM // Avail a node and then initialize it
19. new→LCHILD = NULL
20. new→RCHILD = NULL
21. If (ptr1→DATA < ITEM) then // Insert as the right child
22. ptr1→RCHILD = new
23. Else
24. ptr1→LCHILD = new // Insert as the left child
25. EndIf
26. EndIf
27. Stop

        c) Deleting any data from it ==>
    Another frequently used operations on a binary search tree is to delete any node
    from it. This operation, however, is slightly complicated than the previous two
    operations discussed.Here we have three cases
    Case 1: N is the leave node
    Case 2: N has exactly one child
    Case 3: N has two children
    Algorithm DeleteBST(ROOT, ITEM)
1. ptr = ROOT, flag = FALSE
2. While (ptr ¹ NULL) and (flag = FALSE) do // Step to find the location of the node
3. Case: ITEM < ptr→DATA
4. parent = ptr
5. ptr = ptr→LCHILD
6. Case: ITEM > ptr→DATA
7. parent = ptr
8. ptr = ptr→RCHILD
9. Case: ptr→DATA = ITEM
10. flag = TRUE
11. EndCase
12. EndWhile
13. If (flag = FALSE) then // When the node does not exist
14. Print “ITEM does not exist: No deletion”
15. Exit // Quit the execution
16. EndIf
DECIDE THE CASE OF DELETION
17. If (ptr→LCHILD = NULL) and (ptr→RCHILD = NULL) then //Node has no child
18. case = 1
        19. Else
20. If (ptr→LCHILD ¹ NULL) and (ptr→RCHILD ¹ NULL) then
// Node contains both the child
21. case = 3
        22. Else // Node contains only one child
23. case = 2
        24. EndIf
25. EndIf

        d) Traversing the tree ==>
• All the traversal operations for binary tree are applicable to binary search trees
without any alteration.
• It can be verified that inorder traversal on a binary search tree will
give the sorted order of data in ascending order.
• If we require to sort a set of data, a binary search tree can be built
with those data and then inorder traversal can be applied.
• This method of sorting is known as binary sort and this is why binary
search tree is also termed as binary sorted tree.
->This sorting method is considered as one of the efficient sorting
method.

==>Note:
• Inorder traversal on a BST gives the data
in ascending order.
• The minimum value is at the left-most
node.
• The maximum value is at the right-most
node

    3.APPLICATIONS OF BST ==>
    • For efficient searching.
    • For sorting data in increasing order.
    • For indexing records in files

    4.TIME COMPLEXITY:
    • Sorting
         Complexity ≈ Building a binary search tree ≈ O(nlog2n)
    • Searching
         Best case: O(1)
         WOrst case: O(n)
         Average case: O(log2n)

   * * */

}

//1.DEFINING STRUCTURE OF A NODE OF A BST:
 class TreeNodeTry<T extends Comparable<T>>{
    //If we want to store elements other than number or string then we can use comparable
    //as it is but if we want to use any user defined dtatype like student,book,etc
    //then we have to define compare methpd for them.
    //So T should be either numeric or a String type. or define comparable for any other
    T element;
    TreeNodeTry<T> left;
    TreeNodeTry<T> right;
    public TreeNodeTry(T o) { //Constructor to create a tree if we pass existing BST in it
        this.element = o;
        this.left = null;
        this.right = null;
    }
    public TreeNodeTry() { //Default constructor
        this.element = null;
        this.left = null;
        this.right = null;
    }
// Methods of this class are defined next ...to be added here.
}

//2.DEFINING STRUCTURE OF BST ALONG WITH ITS METHODS
 class TreeNode<T extends Comparable<T>>{
    T element;
    TreeNode<T> left;
    TreeNode<T> right;
    public TreeNode(T o) {
        this.element = o;
        this.left = null;
        this.right = null;
    }
    public TreeNode() {
        this.element = null;
        this.left = null;
        this.right = null;
    }
// Methods of this class are defined next ...to be added here.

    //1.INSERTION
    // This part of the program define the insertion of a node into a BST. */
    public void insert(T o) {
        if (element.compareTo(o) < 0) {//Here compareTo will compare the current node with o
            //if the value of o is greater than curr node then "compareTo(o) < 0"
            if (right == null) {
                right = new TreeNode<T>(o);
            } else {
                right.insert(o);
            }
        } else if (element.compareTo(o) > 0) {
            if (left == null) {
                left = new TreeNode<T>(o);
            } else {
                left.insert(o);
            }
        }
    }

    //2.DELTEION
    // CASE 1:
    TreeNode delete(TreeNode root, T key) {
        /* Base Case: If the tree is empty */
        if (root == null) return root;
        /* Otherwise, recur down the tree */
        if (root.element.compareTo(key) > 0)
            root.left = delete(root.left, key);
        else if (root.element.compareTo(key) < 0)
            root.right = delete(root.right, key);
// if key is same as root's key, then This is the node
// to be deleted
        else //CASE 2 :

        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
// node with two children: Get the inorder successor
            root.element = inSucc(root.right);
// Delete the inorder successor
            root.right = delete(root.right, this.element);
        }
        return root;
    }

    //3.METHOD FOR INORDER SUCCESSOR
    // Method to find the inorder successor of a node --> GO right from curr node
    // then go left till the left becomes null

    public T inSucc(TreeNode root) {
        T minv = this.element;
        while (root.left != null)
        {
            minv = this.left.element;
            root = root.left;
        }
        return minv;
    }

    //4.SEARCHING
    // Method to find the inorder successor of a node
    public TreeNode search(T key) {
// Base Cases: root is null or key is present at root
        if (this == null) {
            return null;
        } else {
            if (this.element.compareTo(key) == 0)
                return this;
// val is greater than root's key
            if (this.element.compareTo(key) > 0) {
                if (this.left == null) return null;
                return this.left.search(key);
            } else {
                if (this.right == null) return null;
// val is less than root's key
                return this.right.search(key);
            }
        }
    }
        public void search_Result(T key){
            if(search(key) == null)
            {
                System.out.println("Not Found");
            }
            else
            {
                System.out.println(key + " : Found");
            }
        }

        //5. TRAVERSAL:
        static void inorder(TreeNode<Integer> R){
            if(R !=null) {
                inorder(R.left);
                R.visit();
                inorder(R.right);
            }
        }
        //5.2 PREORDER TRAV
        static void preorder(TreeNode<Integer> R) {
            if(R !=null){
                R.visit();
                preorder(R.left);
                preorder(R.right);
            }
        }

        //5.3 POSTORDER TRAV
        static void postorder(TreeNode<Integer> R) {
            if(R !=null) {
                postorder(R.left);
                postorder(R.right);
                R.visit();
            }
        }

    public void visit(){
        System.out.println(this.element + " ");
    }



    public static void main(String args[]) {
        TreeNode<Integer> root = new TreeNode(6);
        root.insert(5);
        root.insert(7);
        root.insert(4);
        inorder(root); //CORRECT
        preorder(root); //CORRECT
        postorder(root);//CORRECT
        root.delete(root , 5);
        inorder(root);
        System.out.println();
        System.out.println(root.search(7).element);
        root.search(12);
        root.search(-112);
    }
// End of all methods of this program


} // End of the program



