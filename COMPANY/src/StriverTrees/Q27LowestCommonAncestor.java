package StriverTrees;

public class Q27LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
//        n1.left.right =  -> false
        int n1 = 1,n2 = 9;
        Node lowestCommonAncestor = lca(root,n1,n2);
        Node lowestCommonAncestor2 = striverlca(root,n1,n2);
        System.out.println(lowestCommonAncestor.data);
        System.out.println(lowestCommonAncestor2.data);
    }

    //my - works but condition got lengthy
    private static Node lca(Node root, int n1, int n2) {
        if (root==null) return null;//obvious
        if (root.data==n1 || root.data==n2) return root; //obvious -- if any other node will be in its child then also root will be ancestor
        Node lhs = lca(root.left,n1,n2);  //get left status
        Node rhs = lca(root.right,n1,n2); //get right sides status
        if ((lhs!=null&&(lhs.data==n1 || lhs.data==n2)) &&
                (rhs!=null&&(rhs.data==n1 || rhs.data==n2)))  //if left and right both has the data then return current node
            return root;

        if (lhs != null) return lhs; //if not null then return this as this must would be the ancestor
        if (rhs != null) return rhs;//if not null then return this as this must would be the ancestor
        return null; //just to secure return type
    }


    //Strivers implementation - more easy - use this

    private static Node striverlca(Node root, int n1, int n2) {
        if ((root==null) || root.data==n1 || root.data==n2) return root;
        Node lhs = striverlca(root.left,n1,n2);  //get left status
        Node rhs = striverlca(root.right,n1,n2); //get right sides status

        if (lhs == null) return rhs; //if lhs is null then return rhs as this must would be having a node or the ancestor
        if (rhs == null) return lhs; //if rhs is null then return lhs as this must would be having a node or the ancestor

        return root; //if both are not null then we got both the data so return current node as ancestor
    }
}
