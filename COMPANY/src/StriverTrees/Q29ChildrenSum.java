package StriverTrees;

public class Q29ChildrenSum {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(7);
        root.right.right = new Node(30);


        inOrder(root);

        childrenSum(root);
        System.out.println();
        inOrder(root);

    }
   public static void inOrder(Node root){
        if (root!=null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
//MINE WORKS ----------------------------------
    private static void childrenSum(Node root) {
        //aways keep track of nulls
        if (root == null) return;
/*no need -- >>while going down  - modify the node vaue if node vaue is less than equal to sum of its children--NO NEED*/
//CORRECT -- ONLY DO THIS --> while going down  - modify the childs vaue equal to its parent if node vaue is grerater than sum of its children

        if (root.left != null && root.right != null) {
            if (root.data > (root.left.data + root.right.data)) {
                root.left.data = root.data;
                root.right.data = root.data;
            }
        } else if (root.left != null) {
            if (root.data > (root.left.data)) {
                root.left.data = root.data;
            }
        } else if (root.right != null) {
            if (root.data > (root.right.data)) {
                root.right.data = root.data;
            }
        }

        childrenSum(root.left);
        childrenSum(root.right);
//while going up  - modify the node vaue equal to sum of its children
        if (root.left != null && root.right != null) {
            root.data = root.left.data + root.right.data;
        } else if (root.left!=null) {
            root.data = root.left.data;

        }else if (root.right!=null) {
            root.data = root.right.data;
        }


    }


    //STRIVERS ----
    static void changeTree(Node  root) {
        reorder(root);
    }
    static void reorder(Node  root) {
        if (root == null) return;
        int child = 0;
        if (root . left!=null) {
            child += root . left . data;
        }
        if (root . right!=null) {
            child += root . right . data;
        }

        if (child < root . data) {
            if (root . left!=null) root . left . data = root . data;
            else if (root . right!=null) root . right . data = root . data;
        }

        reorder(root . left);
        reorder(root . right);

        int tot = 0;
        if (root . left!=null) tot += root . left . data;
        if (root . right!=null) tot += root . right . data;
        if (root . left!=null || root . right!=null) root . data = tot;
    }

}
