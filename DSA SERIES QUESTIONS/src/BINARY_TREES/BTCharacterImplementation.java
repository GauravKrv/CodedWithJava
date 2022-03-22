package BINARY_TREES;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//BELOW CODE HAS FOLLOWING BT FUNCTIONS :
//insert(char),insert(string),inorder(Node)
//bt should be like create a bt with curr node
//insert in a bt with root r
public class BTCharacterImplementation {
    static class Node {
        char key;
        Node left,right;
        Node(char key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    static Node root;

    static int diameter(Node root)
    {
        if(root==null)return 0;
        int d1=1+height(root.left)+height(root.right);
        int d2=diameter(root.left);
        int d3=diameter(root.right);

        return Math.max(d1,Math.max(d2,d3));
    }
    //RECHECK THE DELETENNODE'S CODE OR FIND ANTHER WAY TO DELETE A NODE FROM A BT
    //below mehod disturbs the place of the last node only if a node to be deleted is not last node
    static void delete(Node root, char key)
    {
        ;

        if (root == null||root.left == null && root.right == null)
        {
            if (root!=null && root.key == key) {
                root = null;
            }
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null, keyNode = null;

        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp.key == key) {
                keyNode = temp;
                //break; -- DONT BREAK, AS WE HAVE TO FIND THE LAST NODE ALSO
            }

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (keyNode != null)
        {
            char x = temp.key; //STORE THE LAST NODE IN A VARIABLE
            deleteDeepest(root, temp); // DELETE THE TEMP NODE OR LAST NODE
            keyNode.key = x; //Store the last node's value at the keyNode's position
        }
    }
    static void deleteDeepest(Node root,Node delNode)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null;

        // Do level order traversal until last node
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp == delNode)
            {
                temp = null;
                return;//here the last node gets deleted

            }
            if (temp.right!=null)
            {
                if (temp.right == delNode)
                {
                    temp.right = null;// or here the last node gets deleted
                    return;
                }
                else
                    q.add(temp.right);
            }

            if (temp.left != null)
            {
                if (temp.left == delNode)
                {
                    temp.left = null;// or here the last node gets deleted
                    return;
                }
                else
                    q.add(temp.left);
            }
        }
    }
    static int height(Node root)
    {
        if(root==null)
            return 0;
        else
            return (1+Math.max(height(root.left),height(root.right)));
    }
    static void insert(char key)
    {
        if (root==null){
            root = new Node(key);
            return;
        }
        Node curr = new Node(key);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node c = q.poll();
            if (c.left==null){
                c.left = curr;
                break;
            }else{
                q.add(c.left);
            }
            if (c.right==null){
                c.right = curr;
                break;
            }else{
                q.add(c.right);
            }
        }
    }
    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }


    public static void main(String[] args) {
        root = new Node('a');
        root.left = new Node('b');
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of nodes to be entered : ");
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){
            System.out.println("Enter value "+i+" : ");
            char val = sc.next().charAt(0);
            insert(val);
        }

        inorder(root);
        System.out.println();
        System.out.println(diameter(root));

    }



}

class BTGenericString {
    static class Node {
        String key;
        Node left,right;
        Node(String key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    static Node root;

    static void insert(String key){
        if (root==null){
            root = new Node(key);
            return;
        }
      Node curr = new Node(key);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node c = q.poll();
            if (c.left==null){
                c.left = curr;
                break;
            }else{
                q.add(c.left);
            }
            if (c.right==null){
                c.right = curr;
                break;
            }else{
                q.add(c.right);
            }
        }
    }

    public static void main(String[] args) {
        root = new Node("aa");
        root.left = new Node("bb");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of nodes to be entered : ");
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){
            System.out.println("Enter value "+i+" : ");
            String val = sc.next();
            insert(val);
        }

        inorder(root);

    }

    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }
}

