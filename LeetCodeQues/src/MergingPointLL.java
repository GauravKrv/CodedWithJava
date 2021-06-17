import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MergingPointLL {
    public static void main(String[] args) {
        JLinkedList<Integer> A = new JLinkedList<>();
       // for(int i =9;i<15;i++)
        A.head.data = 1;
       // A.insertEnd(1);
        A.insertEnd(12);
        A.insertEnd(13);
        A.insertEnd(14);
        A.insertEnd(15);

        System.out.println(A.head.data);

        JLinkedList<Integer> B = new JLinkedList<>();
        B.head.data = 2;
        B.insertEnd(22);
        B.insertEnd(12);
        B.insertEnd(13);
        B.insertEnd(14);
        B.insertEnd(15);


        JLinkedList.Node head2;
        JLinkedList.Node headA = A.head;
        System.out.println("dATA AT Next HEAD OF A = " +headA.next.data);
        JLinkedList.Node headB = B.head;

        while (headA!=null) {
             head2 = B.head;
            while (head2 != null){
                if (headA.data==head2.data){
                    System.out.println("Merging poit = " + headA.data);
                    break;
                }
                head2 = head2.next;
            }
            try {
                if (headA.data==head2.data)break;

            }catch (Exception e){

            }
            headA = headA.next;

        }
    }
}

class MergingPointLLUsingMap {
    /*
    * TC = O(m+n)
    * SC = O(n)
    * */
    public static void main(String[] args) {
        JLinkedList<Integer> A = new JLinkedList<>();
        // for(int i =9;i<15;i++)
        A.head.data = 1;
        // A.insertEnd(1);
        A.insertEnd(12);
        A.insertEnd(13);
        A.insertEnd(14);
        A.insertEnd(15);

        System.out.println(A.head.data);

        JLinkedList<Integer> B = new JLinkedList<>();
        B.head.data = 2;
        B.insertEnd(22);
        B.insertEnd(12);
        B.insertEnd(13);
        B.insertEnd(14);
        B.insertEnd(15);


        JLinkedList.Node head2;
        JLinkedList.Node headA = A.head;
        System.out.println("dATA AT Next HEAD OF A = " +headA.next.data);
        JLinkedList.Node headB = B.head;


        HashMap<Integer,Boolean> myMap = new HashMap<Integer, Boolean>();


        while (headB!=null) {
            myMap.put((Integer) headB.data, true);
            headB = headB.next;
        }
            while (headA != null) {
                if (myMap.containsKey(headA.data)) {
                    System.out.println("Merging point = " + headA.data);
                    break;
                }
                headA = headA.next;
            }

    }
}

class MergingPointLLBestApproach {
    /*
     * TC = O(m+n)
     * SC = O(1)
     * */
   public static int length(JLinkedList.Node heads){
       int count = 0;
       while (heads!=null){
           heads = heads.next;
           count++;
       }
       return count;
    }
    public static void main(String[] args) {
        JLinkedList<Integer> A = new JLinkedList<>();
        // for(int i =9;i<15;i++)
        A.head.data = 1;
         A.insertEnd(1);
         A.insertEnd(121);
         A.insertEnd(131);
        A.insertEnd(121);
        A.insertEnd(13);
        A.insertEnd(14);
        A.insertEnd(15);

        System.out.println(A.head.data);

        JLinkedList<Integer> B = new JLinkedList<>();
        B.head.data = 2;
        B.insertEnd(22);
        B.insertEnd(121);
        B.insertEnd(13);
        B.insertEnd(14);
        B.insertEnd(15);


        JLinkedList.Node head2;
        JLinkedList.Node headA = A.head;
        System.out.println("dATA AT Next HEAD OF A = " + headA.next.data);
        JLinkedList.Node headB = B.head;

        int m = MergingPointLLBestApproach.length(headA);
        int n = MergingPointLLBestApproach.length(headB);

        int d = m - n;

        for (int i = 0; i < d; i++) {
            headB = headB.next;
        }

        while (headA != null && headB != null) {
            if (headA.data == headB.data) {
                System.out.println("Merging point = " + headA.data);
                break;
            }
             headB = headB.next;
             headA = headA.next;
           // if(headA.data == null && headB.data == null) System.out.println("No merging");
    }}


}


class MergingPointLLBestApproachJCF {
    /*
     * TC = O(m+n)
     * SC = O(1)
     * */
    public static int length(JLinkedList.Node heads){
        int count = 0;
        while (heads!=null){
            heads = heads.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        LinkedList A = new LinkedList();

        A.addFirst(20);
        // for(int i =9;i<15;i++)

        A.addLast(1);
        A.addLast(121);
        A.addLast(131);
        A.addLast(121);
        A.addLast(13);
        A.addLast(14);
        A.addLast(15);

        System.out.println(A);

        LinkedList B = new LinkedList();

        B.addFirst(201);
        B.addLast(131);
        B.addLast(121);
        B.addLast(13);
        B.addLast(14);
        B.addLast(15);
        System.out.println(B);

        // JLinkedList.Node head2;
        //JLinkedList.Node headA = A.head;
        System.out.println("dATA AT Next HEAD OF A = " + A.peek());
        //JLinkedList.Node headB = B.head;

        int m = A.size();//8
        int n = B.size();//6

        int d = m - n;//2

        for (int i = 0; i < d; i++) {
            //headB = headB.next;
        }

        /*while (headA != null && headB != null) {
            if (headA.data == headB.data) {
                System.out.println("Merging point = " + headA.data);
                break;
            }
            headB = headB.next;
            headA = headA.next;
            // if(headA.data == null && headB.data == null) System.out.println("No merging");
        }*/

    }
}
