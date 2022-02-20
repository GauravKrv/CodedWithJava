package LINKED_LIST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SwapLLNode {

    // A linked list node class

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node head;
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    /* This function prints contents of linked list starting
       from the given Node */
    public void printList()
    {
        Node tNode = head;
        while (tNode != null)
        {
            System.out.print(tNode.data+" ");
            tNode = tNode.next;
        }
    }
    public void swapNodes(int x, int y)
    {
        Node a = head,a2 = head.next;
        Node b = head,b2 = head.next;
        Node currX = head;
        Node currY = head;


// Nothing to do if x and y are same
        if (x == y) return;


        while (a.next.data!=x){
            a=a.next;
            currX = currX.next;
            a2 = a2.next;
        }
        while (b.next.data!=y){
            b = b.next;
            currY = currY.next;
            b2 = b2.next;
        }

        if (a!=null&&b!=null){
           a.next = currY;
           currY.next = a2;

           b.next = currX;
           currX.next = b2;
        }

   /*     // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head,currSw = head.next;
        while (currX.next!=null){
            if (currX.data == x){

                while (currX.next!=null && currX.next.data!=y) {
                    currX.next = currSw.next;
                    prevX.next = currSw;
                    currSw.next = currX;

                    prevX = currSw;
                    prevX.next = currX;
                    currSw = currX.next;

                }
                if (currX.next==null)return;

            }



            prevX = currX;
            currX = currX.next;
            currSw = currSw.next;

        }*/
 }


    public void swapNodesTillNeighbourY(int x, int y)
    {
        if (x == y) return;
        Node prevX = null, currX = head,currSw = head.next;
        while (currX.next!=null){
            if (currX.data == x){  //On reaching my home
                     while (currX.next!=null && currX.next.data!=y) { //Till reaching neighbour
                    currX.next = currSw.next;
                    prevX.next = currSw;
                    currSw.next = currX;  //Swapp till neighbour

                    prevX = currSw;      //Increment of nodes
                    prevX.next = currX;
                    currSw = currX.next;

                }
                if (currX.next==null)return;

            }
            prevX = currX; currX = currX.next; currSw = currSw.next;

        }
    }

    public static void main(String args[])
    {
        SwapLLNode llist = new SwapLLNode();

        /* Constructed Linked List is 1->2->3->4->5->6->7->
           8->8->9->null */

        llist.push(666);
        llist.push(6);
        llist.push(66);
        llist.push(77);
        llist.push(4);
        llist.push(0);
        llist.push(1);
        llist.push(2);
        llist.push(33);


        System.out.println("Linked List before swapping");
        llist.printList();

        llist.LLSwap(4,6);

        System.out.println("Linked List after swapping");
        //llist.printList();
    }

    static void LLSwap(int x,int y){
        // 1->2->3->4->5->6->7->8
        //swap 3 and 5-- needed 2,4,3,5
        //2.n = 5 -- 12[53]45678
        //4.n = 3 -- 12[35]43]678
        //5.n = 4 --12543]678
        //3.n = 6  --12543678

        Node x1=head ,y1 = head;
        Node x2 = head.next;
        Node y2 = head.next;
        Node x3 = head;
        Node y3 = head;

        while (x1.next.data != x){
            x1 = x1.next;
            x2 = x2.next;
            x3 = x3.next;
        }

        while (y1.next.data != y){
            y1 = y1.next;
            y2 = y2.next;
            y3 = y3.next;
        }
        System.out.println("printing  all 6 values");

        System.out.println(x1.data);
        System.out.println(x2.data);
        System.out.println(x3.data);
        System.out.println(y1.data);
        System.out.println(y2.data);
        System.out.println(y3.data);
        System.out.println();
        x1.next = y2;

        y1.next = x2;
        System.out.println(x2.next.data);
        y2.next = x2.next;
        System.out.println(y2.next.data);
        x2.next = y2.next;




    }




}
 class hello {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String inline[] = line.split(",");
        int m = inline.length;

        char[][] matrix = new char[n][m];
        for(int i = 0; i < m; ++i) {
            matrix[0][i] = inline[i].charAt(0);
        }
        for(int i = 1; i < n; ++i) {
            line = br.readLine();
            String inn[] = line.split(",");
            for(int j = 0; j < m; ++j) {
                matrix[i][j] = inn[j].charAt(0);
            }
        }


        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println(0);
        } else {
            int[] height = new int[matrix[0].length];
            for(int i = 0; i < matrix[0].length; i ++){
                if(matrix[0][i] == '1') height[i] = 1;
            }
            int result = largestInLine(height);
            for(int i = 1; i < matrix.length; i ++){
                resetHeight(matrix, height, i);
                result = Math.max(result, largestInLine(height));
            }

            System.out.println(result);
        }
    }

    private static void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }

    public static int largestInLine(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
