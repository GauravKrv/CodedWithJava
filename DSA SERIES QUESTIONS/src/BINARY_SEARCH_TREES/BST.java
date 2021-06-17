package BINARY_SEARCH_TREES;

public class BST {
   static class Node{
       int value;
       Node left;
       Node right;
       int height;
       Node parent;
       Node(int value){
           this.value = value;
           left=right=parent=null;
           height = 0;
       }
    }

    //1.FIND ALGO -
    static boolean find(Node t,int v){ //returns true if the data is found in the tree
       if (t==null) return false;
       if (t.value == v) return true;
       if (v<t.value) return (find(t.left,v));
       else return (find(t.right,v));
    }

    static boolean findIter(Node t, int v){
        while (t!=null){
            if (t.value==-v){
                return true;
            }
            if (v<t.value)
                t = t.left;
            else
                t = t.right;
        }
        return false;
    }
//2.INORDER TRAVERSAL
    static void inorderTraversal(Node t){
       if (t!=null){
           inorderTraversal(t.left);
           System.out.print(t.value+"tValue ");
           inorderTraversal(t.right);
       }
    }

  //3.MINIMUM NODE
    static Node minNode(Node t){
       if (t.left==null) return t;
       else return minNode(t.left);
    }
 //4.MAX NODE
    static Node maxNode(Node t){
        if (t.right==null) return t;
        else return maxNode(t.right);
    }
//5.SUCCESSOR - NEXT VALUE OF CURR VALUE
    static Node successor(Node t){
       if (t.right != null) return minNode(t.right);

       Node y = t.parent;
       while (y!=null && t==y.right){
           t = y;
           y = y.parent;
          }
       return y;
        }
//PREDECESSOR - PREV VALUE ODF CURR VALUE
    static Node predecessor(Node t){
        if (t.left != null) return maxNode(t.left);

        Node y = t.parent;
        while (y!=null && t==y.left){
            t = y;
            y = y.parent;
        }
        return y;
    }
//5.INSERT OPERATION
    static void insert(Node root,Node v){

       if (root==null){
           root = v;
           return;
       }

       if (root.value==v.value) return;

       if (v.value<root.value)
       {
           if (root.left==null) root.left = v;
           else insert(root.left,v);
       }
       else {
           if (root.right==null) root.right=v;
           else insert(root.right,v);
       }
    }
//6.DELETE A NODE
    static void delete(Node root,int v){
       if (root==null) return;

        if (v< root.value) {
            if (root.left!=null)
            {
                delete(root.left,v);
                return;
            }
        }
        if (v> root.value) {
            if (root.right!=null)
            {
                delete(root.right,v);
                return;
            }
        }

        //CHECK FROM HERE
       if (root.parent==null) {root=null; return;}//(root.parent==null && root.value == v)
       if (root.left==null && root.right==null){  //(root.left==null && root.right==null && root.value == v)
           if (root == root.parent.left){
               root.parent.left = null;
           }
           if (root == root.parent.right){
               root.parent.right = null;
           }
       }
       //Delete node with only one child -- Left
       if (root.left!=null && root.right==null && root.value==v){
           root.left.parent = root.parent;
           if (root==root.parent.left) root.parent.left = root.left;
           else root.parent.right = root.left;

           return;
       }
        //Delete node with only one child -- right
        if (root.right!=null && root.left==null && root.value==v){
            root.right.parent = root.parent;
            if (root==root.parent.right) root.parent.right = root.right;
            else root.parent.left = root.right;

            return;
        }

        //Delete node with 2 children******
        //Copy pred(v) into curr node
        if (root.left!=null && root.right!=null && root.value==v) {
            Node pv = predecessor(new Node(v));
            root.value = pv.value;
            delete(root.left, pv.value);
        }
     }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node n = new Node(12);
        insert(root,n);
        Node n2 = new Node(17);
        insert(root,n2);
        Node n3 = new Node(9);
        insert(root,n3);

        inorderTraversal(root);

    }
}





