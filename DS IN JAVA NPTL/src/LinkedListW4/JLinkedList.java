package LinkedListW4;

class JLinkedListW4L3 {
   /*
   CAN BE DONE IN TWO WAYS:
   1.We can make  lL of our own
   2.Or we can uses the JCF

   WE WILL CREATE LL OF GENERIC TYPE SO THST IT CAN HOLD DATA OF ANY TYPE
   PROCESS:
   1-Field defifnitioin of the class
   2-Methods definition for the class

   SIGNATURES FOR DIFFERENT METHODS
1. Insertion operations
• Insertion at front-> public void insertFront(T data) { … }
• Insertion at end-> public void insertEnd(T data) { … }
• Insertion at any position -> public void insertKey(T data, T key) { … }
2. Traversal
• Printing the collection -> public void printList() { … }
• Reversing the ordering of elements -> public void reverse() { … }
3. Merging operation
• Merging two list into a single list -> public void merge(JLinkedList<T> ll){ … }
4. Deletion operation
• Deletion from front -> public T deleteFront(T data) { … }
• Deletion from end -> public T deleteEnd(T data) { … }
• Deletion from any position -> public void deleteKey(T data, T key)





   * * */
}
//
//1. This program shows how to define a (single) linked list
public class JLinkedList<T> {
    Node head; // head of list
    class Node {  //-->Called inner class delaration
        T data;
        Node next;
        // Constructor
        Node (){  //-->Defining constructor for inner class so that we can
            // create a node for head node
            data = null;
            next = null;
        }
        Node(T d){ //->Defining another constructor so that we can create a node for data nodes
            data = d;
            next = null;
        }
    }
    JLinkedList(){ //LinkedList Header Node
        head = new Node();//we created a node using default cons node inside the cons of main class
    }
// Method to maintain the collection to be defined …


//1. Defining the method to Insert at the front
    public void insertFront(T data) {
        // Create a new node with given data
        Node newNode = new Node(data);
        newNode.next = this.head.next; //If list is empty then head.next = NULL
// Make the new node as as the first node
        this.head.next = newNode;
    }

 //2. Defining the method to Insert at the end
    public void insertEnd(T data){
        Node newNode = new Node(data);
        newNode.next = null;
        Node temp = this.head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

//3.insert at any poition i.e after any element with value=key
    public void insertKey(T data , T key) {
        Node newNode = new Node(data);
        newNode.next = null;
        Node temp = this.head;
        boolean status = false;
        while(temp != null){
            if(temp.data == key) {
                status = true;
                break;
            }
            temp = temp.next;
        }
        if(status) { //just cheking if the position is found in LL or not as we did in C
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    //4.Printing every node i the list -- traversal operation
    public void printList(){
        Node currNode = this.head.next;
        System.out.print("LinkedList: ");
// Traverse through the LinkedList
        while(currNode != null) {
// Print the data at current node
            System.out.print(currNode.data + " ");
// Go to next node
            currNode = currNode.next;
        }
        System.out.println();
    }

    //5. Defining the method to merge two lists into a single list
    public void merge(JLinkedList<T> l2) { //This method will take an object of JLinkedList
        //class as an argument
        Node l1Node = this.head;
        Node l2Node = l2.head; //Initialising two pointers for pointing to the head f the
        //two LL to be merged
        while(l1Node.next != null ) {
            l1Node = l1Node.next;
        }
        l1Node.next = l2Node.next;
        //free(l2.head); // Return the node to free memory????->error
    }
    //6.Defining the method to delete a node at the front
    public T deleteFront() {
        T x = null;
        Node temp = this.head.next, prev = null;
        if(temp != null) {
            x = temp.data;
            this.head.next = temp.next; // Changed head
// Display the message
            System.out.println("Element deleted");
        }
        return x; // Return the deleted data
    }

    //7.Defining the method to delete a node from the end
    public T deleteEnd () {
        T x = null;
        Node temp = this.head.next, prev = null;
        if (temp != null) { // If the list is not empty
            while(temp != null) { // Move to the end node
                prev = temp;
                temp = temp.next;
            }
            if(temp!=null)
            x = temp.data;
            prev.next = null;
        }
        return x;
    }

    //8.Defining the method to delete a node from any position with elem to be deleted=key
    public void deleteKey(T key){
        Node temp = this.head.next, prev = null;
        while(temp != null) {
            if(temp.data == key) {
                prev.next = temp.next;
// Display the message
                System.out.println(key+ " -> deleted, Resultant list = ");
                break;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
    }

    //9.Reversing a single linked list????????????
    public Node remove(Node n) {
        Node current = n;
        Node next = n.next;
        Node prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head.next = prev;
        return next;
    }
    public void reverse() {
        Node currNode = this.head.next;
        System.out.print("Reversed List : ");
        remove(currNode);
    }


}

 // End of JLinkedList class decl
//2.DRIVER CLASS WITH TO USE THE LLINKED LIST CREATED WITH INSERTION OPERATIONS
 class LinkedListInsertionDemo {
     public static void main(String args[]) {
         JLinkedList<Integer> list = new JLinkedList<>();//Here Inteer is used as
         //we want to store object with argument type integer
         list.insertEnd(9);
         list.printList();
         list.insertFront(5);
         list.printList();
         list.insertEnd(10);
         list.printList();
         list.insertKey(7, 5); //Insert the data after the node which contans 5
         list.printList();
         list.insertKey(12, 0);//No "0" is pres in LL so will not be inserted
         list.printList();
         list.insertKey(13, 10);
         list.printList();
         list.insertFront(2);
         list.printList();
     }
 }

 //3.DRIVER CLASS TO USE THE LINKED LIST CREATED WITH MERGING OPERATIONS
 class LinkedListMergingDemo {
     public static void main(String[] args) {
         JLinkedList<Integer> list1 = new JLinkedList<Integer>();
         JLinkedList<Integer> list2 = new JLinkedList<Integer>();
         list1.insertFront(1);
         list1.insertFront(2);
         list1.insertEnd(3);
         list1.insertEnd(4);
         list1.printList();
         list2.insertFront(5);
         list2.insertEnd(6);
         list2.printList();
// Merge the list list1 fter list2 and return the result as list 1
         list1.merge(list2);
         System.out.print("Merged");
         list1.printList();
     }
 }

//4..DRIVER CLASS TO USE THE LINKED LIST CREATED WITH DELETING OPERATIONS
class LinkedListDeletionDemo {
    public static void main(String[] args) {
        JLinkedList<Integer> list = new JLinkedList<Integer>();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);
        list.insertFront(4);
        list.insertFront(5);
        list.insertFront(6);
        list.insertFront(7);
        list.insertFront(8);
// Print the LinkedList
        list.printList();
        list.deleteKey(1);
        list.printList();
        list.deleteFront( );
        list.printList();
        list.deleteEnd();
        list.printList();
    }
}

//5.DRIVER CLASS TO USE THE LINKED LIST CREATED WITH REVERSING OPERATIONS
class LinkeListReversalDemo{
    public static void main(String args[]) {
        JLinkedList<Integer> list = new JLinkedList<Integer>();
        list.insertEnd(9);
        list.printList();
        list.insertFront(5);
        list.printList();
        list.insertEnd(10);
        list.printList();
        list.insertKey(7,5);
        list.printList();
        list.insertKey(12,0);
        list.printList();
        list.insertKey(13,10);
        list.printList();
        list.insertFront(2);
        list.printList();
        list.reverse();
        list.printList();
    }
}














