package StriverTrees;

public class Q32CountNodesInLessComplexity {
    //Given a bin tree is complete, i.e as left as possible
    //i.e lesst than O(n) complexity try to count the nodes
    //WILL ONLY WORK FOR COMPLETE BT--

    public static void main(String[] args) {
        Node root = new StriverTrees.Node(3);
        root.left = new StriverTrees.Node(5);
        root.left.left = new StriverTrees.Node(6);
        root.left.right = new StriverTrees.Node(2);
        root.right = new StriverTrees.Node(1);
        root.right.left = new StriverTrees.Node(0);
        root.right.right = new StriverTrees.Node(8);

        System.out.println(countNodes(root));
    }
        public static int countNodes(Node root) {
        if(root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        //If left and right are equal it means that the tree is complete and hence go for 2^h -1.
        if(left == right) {
//            System.out.println("2<<left = "+(2<<left)); -> gives 8 -- same in c++
//            System.out.println("1<<left = "+(1<<left)); -> gives 4 -- same in c++
            return ((2 << (left)) - 1);

        }
            //else recursively calculate the number of nodes in left and right and add 1 for root.
        else return countNodes(root.left)+ countNodes(root.right)+1;
    }


    public static int getHeightLeft(Node root){
        int count=0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }


    public static int getHeightRight(Node root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }
}