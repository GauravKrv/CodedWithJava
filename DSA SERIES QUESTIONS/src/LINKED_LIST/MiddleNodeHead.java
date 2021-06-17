package LINKED_LIST;

public class MiddleNodeHead {

    static Node head;
    static class Node{
        Node next;
        int data;
        boolean flag = false;
        Node(int data){
            this.data = data;
            next = null;
        }

    }

    static void push(int new_data){
        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
    }

   static void middle_Node_Head(Node h){
        Node s =head,f=head,t=null,p=null;
        if (head.next==null) return;

        while (f!=null){  //SWAPPING ALGO

            if (f.next==null)
            {f = f.next; }
            else {
                p=s;
                s = s.next;
                f = f.next.next;
            }
        }

        t=s;
        p.next = s.next;
        t.next = head;
        head = t;
/*OUTPUT :  list before: 1 2 3 4 5
 list After:  3 1 2 4 5
* */
    }

    static void printList(Node ptr)
    {
        while (ptr != null) {
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int i;
        for (i = 5; i > 0; i--)
            push(i);

        System.out.print(" list before: ");
        printList(head);

        middle_Node_Head(head);

        System.out.print(" list After:  ");
        printList(head);
    }
}
