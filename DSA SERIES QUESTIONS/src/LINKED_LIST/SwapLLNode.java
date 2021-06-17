package LINKED_LIST;

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

        llist.swapNodes(4,6);

        System.out.println("Linked List after swapping");
        llist.printList();
    }




}
