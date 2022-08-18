package StriverTrees;

public class Q20BoundaryTraversal {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(7);
        n1.right.right = new Node(8);

        n1.left.left = new Node(3);
        n1.left.right = new Node(4);
        n1.left.right.left = new Node(5);
        n1.left.right.right = new Node(6);

        traverseBoundary(n1);
    }

    //Correct =-- works -- ERROR IN LEAF TRAVERSAL
    private static void traverseBoundary(Node n1) {
        System.out.print(n1.data+" ");
        traverseLeft(n1.left);
        traverseLeaf(n1);
        traverseRight(n1.right);


    }

    private static void traverseLeaf(Node node) {
        if (node!=null){
            traverseLeaf(node.left);
            if (node.left == null && node.right==null) System.out.print(node.data+" ");;
            traverseLeaf(node.right);
        }
    }

    private static void traverseLeft(Node node) {
        if (node==null) return;
        if (node.left == null && node.right==null) return;
        if (node.left!=null) traverseLeft(node.left);
        else if (node.right!=null) traverseLeft(node.right);

        System.out.print(node.data+" ");


    }

    private static void traverseRight(Node node) {
        if (node==null) return;
        if (node.left == null && node.right==null) return;
        System.out.print(node.data+" ");
        if (node.right!=null) traverseRight(node.right);
        if (node.left!=null) traverseRight(node.left);


    }
}
