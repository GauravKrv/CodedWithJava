package BINARY_TREES;

import java.util.LinkedList;
import java.util.Queue;

/*
Maximum Width of Binary tree is the maximum number of nodes present in a level of the Tree.
In this video, we discuss a function that takes the root of a Binary Tree and returns the maximum width of the Binary Tree.
Hint:- we use level order traversal line by line logic to find maximum width of the Binary Tree.
* */
public class MaxWidthBT {
    public static void main(String args[])
    {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);

        System.out.print(maxWidth(root));
    }

    public static int maxWidth(Node root){
        if(root==null)return 0;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int res=0;
        while(q.isEmpty()==false){
            int count=q.size();
            res=Math.max(res,count);
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return res;
    }
}
