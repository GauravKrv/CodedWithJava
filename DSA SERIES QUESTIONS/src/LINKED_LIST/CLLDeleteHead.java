package LINKED_LIST;

public class CLLDeleteHead {
    class Node {
        Node next;
        int data;
        Node prev;
        Node(int val){
            data = val;
            next = prev = null;
        }
            }
    class CircularLinkedList {

        Node prev;
        Node next;
        int data;
        public CircularLinkedList(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
}
