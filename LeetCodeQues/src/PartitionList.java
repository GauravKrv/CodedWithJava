public class PartitionList {
    public static void main(String[] args) {
        int x = 15;
        JLinkedList<Integer> A = new JLinkedList();
        JLinkedList<Integer> B = new JLinkedList();
        B.insertFront(10);
        A.head.data = 1;
        // A.insertEnd(1);
        A.insertEnd(121);
        A.insertEnd(13);
        A.insertEnd(14);
        A.insertEnd(17);

      //  System.out.println(A.head.data);
       JLinkedList.Node headA = A.head;
        JLinkedList.Node headB = B.head;
     //(int)headA.data;

        headA.data = A.head.data;
        JLinkedList.Node LH = null;
        JLinkedList.Node LT = null;
        JLinkedList.Node MH = null;
        JLinkedList.Node MT = null;
        while (headA!=null){
            if ( (int)headA.data <  x){//*************
                if (LH==null){
                    LH = LT = headA;
                }else {
                    LT.next = headA;
                    LT = headA;
                }

            }else {
                if (MH==null){
                    MH = MT = headA;
                }else {
                    MT.next = headA;
                    MT = headA;
                }
            }
            headA = headA.next;
        }
        if (LH!=null && MH ==null){
            LT.next = null;
            for (headA = LH;headA!=null;headA=headA.next){
                System.out.println(headA.data+"->");
            }
        }else if (LH==null&& MH!=null){
            MT.next = null;
            for (headA = MH;headA!=null;headA=headA.next){
                System.out.println(headA.data+"->");
            }
        }else if (LH!=null&& MH!=null){
            LT.next = MH;
            MT.next = null;
            for (headA = LH;headA!=null;headA=headA.next) {
                System.out.print(headA.data + "->");
            }
    }else {
            System.out.println("Error!");
        }

    }
}
