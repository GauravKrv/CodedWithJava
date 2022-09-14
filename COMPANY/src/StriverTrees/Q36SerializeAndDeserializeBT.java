package StriverTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q36SerializeAndDeserializeBT {
    public static void main(String[] args) {
        StriverTrees.Node root = new StriverTrees.Node(50);
        root.left = new StriverTrees.Node(7);

        root.right = new StriverTrees.Node(2);
        root.right.left = new StriverTrees.Node(7);
        root.right.right = new StriverTrees.Node(30);

        System.out.println("Initial Tree");
        Q29ChildrenSum.inOrder(root);
        String ser = serializeBT(root);

        System.out.println("After serialization : ");
        System.out.println(ser);

//        Node newRoot = deserializeBT(ser);
//        System.out.println("After deserialization : ");
//        Q29ChildrenSum.inOrder(newRoot);

    }
//MODIFY - IT - WONT WOWRK
    private static StriverTrees.Node deserializeBT(String ser) {
        StringTokenizer st = new StringTokenizer(ser,",");
        ArrayList<String> al = new ArrayList<>();
        while (st.hasMoreTokens()){
            al.add(st.nextToken());
        }

        Queue<StriverTrees.Node> q = new LinkedList<>();
        int i = 0;
        String curr = al.get(i++);
//        if (curr.equals("-1")==false)
        q.add(new StriverTrees.Node(Integer.parseInt(curr)));
        StriverTrees.Node root = q.peek();

        boolean left = true;
        while (i<al.size()){
            StriverTrees.Node temp = q.poll();
            if (temp.data!=-1){
                curr = al.get(i++);
                q.add(new StriverTrees.Node(Integer.parseInt(curr))); //left
                if (left==true){
                    root.left = temp;
                }else{
                    root.right = temp;
                }
            }
            left = !left;

        }
        return root;
    }

    //WORKS
    private static String serializeBT(StriverTrees.Node root) {
        StringBuilder sb = new StringBuilder("");
        Queue<StriverTrees.Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty()==false){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                StriverTrees.Node temp = q.poll();
                sb.append(temp.data+","); //appending the current root
                if (temp.data!=-1){  //check if the appended root was null or not
                    if (temp.left!=null){ //if not null do simple bst
                        q.offer(temp.left);
                    }else{
                        q.offer(new StriverTrees.Node(-1)); //just add new null node if null occurs
                    }
                    if (temp.right!=null){
                        q.offer(temp.right);
                    }else{
                        q.offer(new StriverTrees.Node(-1));
                    }
                }
            }
        }

        return String.valueOf(sb);
    }

    //STRIVERS :

    public String serialize(Node root) {
        if (root == null) return "";
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public Node deserialize(String data) {
        if (data == "") return null;
        Queue<Node> q = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            Node parent = q.poll();
            if (!values[i].equals("n")) {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
