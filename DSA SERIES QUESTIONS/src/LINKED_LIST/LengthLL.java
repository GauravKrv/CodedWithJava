package LINKED_LIST;

import java.util.HashSet;

public class LengthLL {
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

 void push(int new_data){
        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
}

static void detect_loop(Node h){
       Node n = h;
       Node n2 = h;
       Node p = n.next;
    System.out.println("Current Linked List  : ");
    int j = 1;

    while (n2.next!=null&&j<5){
           System.out.print(n2.data+"->");
           n2 = n2.next;
           j++;
       }
    System.out.println();
       int i = 1;
      while (n.next != null&&i<5){

          while (p.next!=null){
              if (p.next==n){
                  System.out.println("Loop at node p = "+p.data +" -> "+p.next.data);
                  return;
              }
              p = p.next;
          }

          n = n.next;
          p = n.next;
          i++;

      }


}

static boolean detect_loop2(Node h){
    HashSet<Node> s = new HashSet<>();

    while (h!=null){
        if (s.contains(h)){
            return true;
        }
        s.add(h);

        h = h.next;
    }
    return false;

    //TC=n, SC = n
}
    static void detect_loop3(Node h){
       h.flag = true;
        while (h!=null) {
            if (h.next.flag == false) {
                h.next.flag = true;
            } else {
                System.out.println("Loop found between node " + h.data+"<-->"+h.next.data);
                return;
            }
            h = h.next;
        }
        System.out.println("No loop found");
/*Time complexity:O(n).
Only one traversal of the loop is needed.
Auxiliary Space:O(1).
No extra space is needed.
* */

    }

    static void detect_loop4(Node h){
       // Floyd’s Cycle-Finding Algorithm
        /*Approach: This is the fastest method and has been described below:

Traverse linked list using two pointers.
Move one pointer(slow_p) by one and another pointer(fast_p) by two.
If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.*/
        Node n1 = h;
        Node n2 = h;
        while (n1!=null &&n2!=null&& n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1==n2)break;
        }

        if (n2==null){
            System.out.println("No Loop");
        }else
        System.out.println("Loop found between node " + n1.next.data+"<-->"+n2.data);


/*Time complexity: O(n).
Only one traversal of the loop is needed.
Auxiliary Space:O(1).
There is no space required.*/

    }

    void detectLoop5()
    {
        Node slow_p = head, fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null
                && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop found");
        else
            System.out.println("Loop not found");
    }

    public static void main(String[] args) {
       /* Node n1 = new Node(1);
        n1.next = head;
       head = n1;*/
       /* Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);*/
       /* n2 =  head.next ;
        n3 = n2.next;
        n4 = n3.next;
        n5 = n4.next;
       n5.next = head.next;*/
      /* int num = 5;
       Node p = null;
       for (int i = 2;i<num;i++){

           Node n = new Node(i);
           n2 = n;
           if (i == 2){
               p = n2;
           }

       }
       n2.next = p;
*/

LengthLL linkedList = new LengthLL();
linkedList.push(20);
        linkedList.push(4);
        linkedList.push(15);
        linkedList.push(10);
        linkedList.head.next.next.next.next = linkedList.head;

        detect_loop(head);
        if (detect_loop2(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");

       // detect_loop3(head);
        detect_loop4(head);

    }
}
