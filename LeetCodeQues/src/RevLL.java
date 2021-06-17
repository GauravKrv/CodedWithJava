public class RevLL {
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

        JLinkedList.Node curr = A.head;
        //A.head = headA;
        JLinkedList.Node prev = null;

       // JLinkedList.Node curr;
        while (curr!=null){
            JLinkedList.Node n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        while (prev!=null){
            System.out.print("->"+prev.data);
            prev = prev.next;
        }

        /*
        O/P:
        1
->15->14->13->12->1

        * * */
    }
}
