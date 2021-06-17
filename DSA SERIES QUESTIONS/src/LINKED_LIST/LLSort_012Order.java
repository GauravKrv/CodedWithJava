package LINKED_LIST;

public class LLSort_012Order {

    static Node head;
    class Node{
        Node next;
        Node prev;
        int data;
        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    void push(int new_data){
       Node new_node = new Node(new_data);

        new_node.next = head;


        head = new_node;
    }



    void sortList() {
        // initialise count of 0 1 and 2 as 0
        int count[] = {0, 0, 0};

        Node ptr = head;

        /* count total number of '0', '1' and '2'
         * count[0] will store total number of '0's
         * count[1] will store total number of '1's
         * count[2] will store total number of '2's  */
        while (ptr != null) {
            count[ptr.data]++;
            ptr = ptr.next;
        }


        int i = 0;
        ptr = head;
        while (ptr!=null){
            if (count[i]==0){
                i++;
            }else {
                ptr.data = i;
                count[i]--;
                ptr = ptr.next;
            }

        }
    }
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        LLSort_012Order llist = new LLSort_012Order();

        /* Constructed Linked List is 1->2->3->4->5->6->7->
           8->8->9->null */
        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);

        System.out.println("Linked List before sorting");
        llist.printList();

        llist.sortList();

        System.out.println("Linked List after sorting");
        llist.printList();
    }


}
