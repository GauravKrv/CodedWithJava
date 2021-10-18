public class AddTwoLL {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  static ListNode addTwo(ListNode h1, ListNode h2){
        h1 = reverse(h1);
        h2 = reverse(h2);
    /*  System.out.println();
      printList(h1);
      System.out.println();
      printList(h2);
      System.out.println();*/
      ListNode t1 = h1, t2 = h2, t3;
      ListNode h3 = new ListNode((t1.val + t2.val)%10);
      int carr = (t1.val + t2.val)/10;
      t3 = h3;
      int sum = 0;
      t1 = h1.next;
      t2 = h2.next;

        while (t1!=null && t2!=null){
            ListNode n = new ListNode((t1.val + t2.val + carr)%10);
                carr = (t1.val + t2.val + carr)/10;

                t3.next = n;
                t3 = n;

            t1 = t1.next;
            t2 = t2.next;

           // System.out.print(t3.val+" <- ");

        }

        while (t1!=null){
            ListNode n = new ListNode((t1.val + carr)%10);
            carr = (t1.val + carr)/10;
            t1 = t1.next;
            t3.next = n;
            t3 = n;
        }

      while (t2!=null){
          ListNode n = new ListNode((t2.val + carr)%10);
          carr = (t2.val + carr)/10;
          t2 = t2.next;

          t3.next = n;
          t3 = n;
      }

      while (carr!=0){
          ListNode n = new ListNode(carr%10);
          carr = carr/10;
          t3.next = n;
          t3 = n;
      }
      System.out.println();
      return reverse(h3);


  }

  static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
  }

  static void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
  }

    public static void main(String[] args) {
        int arr[] = {2,4,3};
        int arr2[] = {5,6,4};
      /*  char ar[] = {'a','b','c'};
        System.out.println(String.copyValueOf(ar).length());*/
        ListNode h1 = new ListNode(arr[0]);
        ListNode temp = h1;
        for (int i =1;i<arr.length;i++){
            ListNode t1 = new ListNode(arr[i]);
            temp.next = t1;
            temp = t1;

        }

        ListNode h2 = new ListNode(arr2[0]);
         temp = h2;
        for (int i =1;i<arr2.length;i++){
            ListNode t2 = new ListNode(arr2[i]);
            temp.next = t2;
            temp = t2;

        }

       /* printList(h1);
        h1 = reverse(h1);
        printList(h1);
        printList(h1);
        System.out.println();
        printList(h2);*/
        ListNode res = addTwo(h1,h2);
        printList(res);
    }
}
