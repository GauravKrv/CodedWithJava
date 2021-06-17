package LINKED_LIST;

public class FindLoop {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.right = new Node(11);
        head.right.right = new Node(12);
        head.right.right.right = new Node(13);
        head.right.right.right.right = head;
        findLoop(head);
       destroyLoop(head);
        findLoop(head);


    }
    static void destroyLoop(Node head){
        Node slwPtr = head;
        Node fastPtr = head;
        Node p3 = head;
        int c = 0;
        while (slwPtr!=null && fastPtr!=null  && fastPtr.right!=null && slwPtr.right!=head){
            slwPtr = slwPtr.right;
            //p3 = fastPtr.right;
            c++;
            fastPtr = fastPtr.right.right;
            if (slwPtr==fastPtr){
                break;
            }
        }
        if(fastPtr!=null && slwPtr.right!=head){
            Node temp = head;
            int i =0;
            while(i++!=c){
                temp = temp.right;
            }
            temp.right = null;
        }
        if (slwPtr.right==head) {
            slwPtr.right = null;
        }

    }
    static void findLoop(Node head){
        Node slwPtr = head;
        Node fastPtr = head;
        while (slwPtr!=null && fastPtr!=null  && fastPtr.right!=null){
            slwPtr = slwPtr.right;
            fastPtr = fastPtr.right.right;
            if (slwPtr==fastPtr){
                System.out.println("Loop found");
                break;
            }
        }
        if (fastPtr==null){
            System.out.println("Loop not fpund");
        }
    }
}
