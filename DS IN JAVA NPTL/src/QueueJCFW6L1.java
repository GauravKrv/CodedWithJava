import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueJCFW6L1 {
    /*
    1.QUEUE JCF :
    -->To facilitates the queue structure and its variants, java.util package provides
    the Queue interface which extends the Collection interface.
    -->The another variants of queue is called deque (double ended queue), which
    allows both insertion and deletion at both the ends. In JCF, the Deque interface is
    defined, which extends Queue interface and the Deque interface is implemented
    by LinkedList class

     2.IMPORTANT CHARACHTERISTICS
    • The Java Queue supports all methods of Collection interface including insertion,
deletion, etc.
    • Class like LinkedList, ArrayBlockingQueue and PriorityQueue are the most frequently used
implementations of Queue INTERFACE.
    • BlockingQueues have thread-safe implementations.
    • The queues which are possible with java.util package are unbounded queues. On the
    other hand, the queues according to java.util.concurrent package are the bounded queues.
    • All queues except the Deques support insertion and removal at the tail and head
of the queue, respectively. The Deques support insertion and removal of elements
at both the ends.


    3.METHODS DECLARED BY THE INTERFACE QUEUE:
    Methods                                 Description
boolean add(object) It is used to insert the specified element into this queue and return
                        true upon success.
boolean offer(object) --> It is used to insert the specified element into this queue.
Object remove()     -->It is used to retrieves and removes the head of this queue.If it
                        empty then it will throw an exception
Object poll()   -->It is used to retrieves and removes the head of this queue, or returns
                    null if this queue is empty.
Object element() -->It is used to retrieves, but does not remove, the head of this queue.
Object peek()   --> It is used to retrieves, but does not remove, the head of this queue,
                    or returns null if this queue is empty

    4.PRIORITY QUEUE AND ITS METHODS:
    --It inserts the element in the order in which their priority is set, it actually
    violates  FIFO order
    --Being an interface the queue needs a concrete class for the declaration and the most common classes are the
    PriorityQueue and LinkedList. The PriorityQueue class includes six constructors.
    CONSTRUCTORS                    DESCRIPTION
PriorityQueue( ) --->The default constructor builds an empty queue. Its starting capacity is 11.
PriorityQueue(int capacity) --->This constructor builds a queue that has the specified initial capacity.
PriorityQueue(Comparator<? super E> comp) --->This constructor specifies a comparator.
PriorityQueue(int capacity,Comparator<? super E> comp) -->This constructor builds a queue
                                        with the specified capacity and comparator.
PriorityQueue(Collection<? extends E> c) --->This constructor creates a queue which can
                                            hold a generic collection.
PriorityQueue(PriorityQueue<? extends E> c) --->This constructor create queues that are
                                initialized with the elements of the collection passed in c

    METHODS:
    • All the methods declared in the Queue interface are fully defined in the
    PriorityQueue class.
    • Further, since it is a subtype of Collections class, it inherits all the methods
    of it, namely size(), isEmpty(), contains(), etc


       5.OPERATOIINS ON PRIORITY QUEUES With exceptions and without exceptions:
       Queue of JCF supports all operations necessary to maintain a queue structure,
       which are summarized as:
Operation               Throws exception                  Special value
Insert          =>             add(e)                          offer(e)
Remove          =>             remove()                        poll()
Examine         =>             element()                       peek()
    * * */
}
//1.CREATING A QUEUE USING PRIORITY QUEUE CLASS
/* To create a queue using PriorityQueue class along with some common operations.
Queue of string objects.-->IN PRIORITY QUEUES , ELEMENTS ARE INSERTED IN DESCENDING ORDER OF PRIORITY. e.g
    "A" HAS LESS PRIORITY THAN "T" */
 class QueueCreateExample1 {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();// ************ CHECK THE DECLARATION
 queue.add("one"); // Adding some elements into the queue-->it will be added with PRIORITY
        queue.add("two");//Queue will resolve that which as the highest priority to be added
        queue.add("three");//It may be added in dictionary priority for strings
        queue.add("four");//But wont be in same order of ading
        System.out.println(queue); // Display the contents in queue
        queue.remove("three");
        System.out.println(queue);
        System.out.println("Queue Size: " + queue.size());
        System.out.println("Queue Contains element 'two' or not? : " + queue.contains("two"));
        queue.clear(); // To empty the queue
    }
}

//2.CREATING A QUEUE USING LINKED LIST CLASS
/* To create a queue using LinkedList class along with some common
operations. Queue of integer numbers. */
class QueueCreateLinkedList {
    public static void main(String[] args) {
// Declaration of a queue of LL type object using LinkedList class
        Queue<Integer> q = new LinkedList<Integer>();
// Adds elements {0, 1, 2, 3, 4} to queue
        for(int i=0; i<5; i++)
            q.add(i);

        System.out.println("The queue contains :"+q);// Display contents of the queue.
        int x = q.remove();// To remove the head of queue.
        System.out.println("The element deleted :"+ x);
        System.out.println(q);

        int head = q.peek();// Display contents of the queue.
        System.out.println("head of queue:"+ head);

        int size = q.size();// The size of the queue
        System.out.println("Size of queue: "+ size);
    }
}

//3.INSERTION IN QUEUE
/* To create queue structure with ArrayBlocking class (same as PriorotyQueue
class) and insert elements and queue structure grows automatically. */
 class QueueInsertOperation1 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        //If we want to use any multithreading program and we want concurrent insertion in it then
        //we use ArrayBlockingQueue, Here our Queue is a BlockingQueue
        System.out.println(queue.add(1));
        System.out.println(queue.add(2)); // Maximum capacity
        System.out.println(queue);
        System.out.println(queue.add(3)); // Queue grows dynamically
        System.out.println(queue);
        for(int i=9; i>0; i--) // Add more … to the queue
            queue.add(i); //Queue grows further dynamically
        System.out.println(queue);
    }

}

//3.2.INSERTION OF STRING
/* Like the add(), the Queue interface has the offer() operation, which is also
used to insert new element into the queue. If it performs insert operation
successfully, it returns “true” value. Otherwise, it returns “false” value. The
following program demonstrate this functionality. */
 class QueueInsertOperation2 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        System.out.println(queue.offer("One"));
        System.out.println(queue.offer("Two"));
        System.out.println(queue);
        System.out.println(queue.offer("Nine"));
        System.out.println(queue);
    }
}

//4.DELETION FROM A QUEUE:
/*
• There are two methods: remove() and poll() can be used to perform delete
operation in a queue structure.
• The delete operations returns the front element of the queue, if it performs successfully.
Queue supports delete operation in two forms:
1. Queue.remove(): It throws java.util.NoSuchElementException exception if the
operation fails.
2. Queue.poll(): It returns a special value if the operation fails. Here, special value
may be either “false” or “null”
Removing element from a queue
  * * */
// Java Queue delete operations with remove() method
class QueueRemoveOperation{
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("One");
        queue.offer("Two");
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove()); // Throws an exception
    }
}
/* The poll() operation is used to delete an element from the head of the
queue. If it performs delete operation successfully, it returns the head
element of the queue. Otherwise it returns “null” value. */
class QueuePollOperation {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("One");
        queue.offer("Two");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll()); // It returns “null”
    }
}

//5.QUEUE TRAVERSAL OPERATION
/*Following example illustrate how to maintain a queue of using user defined objects with the
        following tasks.
        • Create a queue with objects of class Book.
        • Traverse the newly created queue.
        • Remove an element and then traverse the queue.
        This example defines a class Book and add books to queue and then print all the books
        object in the queue.
        Queue traversal
        Note:
        • The elements in PriorityQueue must be of Comparable type.
        • String and Wrapper classes are Comparable by default.
        • To add user-defined objects in PriorityQueue, you need to implement Comparable
interface.*/
class Book2 implements Comparable<Book2>{ //comparable is an interface defined in util having a compareTo() method
    int bookId;
    String name;
    String author;
    String publisher;
    int quantity;
    public Book2(int id, String name, String author, String pub, int qty) {
        bookId = id;
        this.name = name;
        this.author = author;
        publisher = pub;
        quantity = qty;
    }
// Methods under this class are defined next
// Defining the compareTo() method
public int compareTo(Book2 b) {
    if(bookId>b.bookId)
        return 1;
    else
    if(bookId<b.bookId)
        return -1;
    else
        return 0;
}
} // End of class Book
//DRIVER CLASS
class QueueCreateDemo { //No need to use compareTo for a queue but is used for a Prority quue
    public static void main(String[] args) {
        PriorityQueue<Book2> queue=new PriorityQueue<Book2>();
//Creating Books
        Book2 b1=new Book2(111,"Joy with Java","Debasis Samanta","Elsevier",8);
        Book2 b2=new Book2(222,"Complete Java","Herbert Schildt","Oracle",6);
        Book2 b3=new Book2(333,"Headstart Java","Forouzan","O’Reilly",4);
//Adding Books to the queue
        queue.add(b1);
        queue.add(b2);
        queue.add(b3);
        System.out.println("Traversing the queue elements:");
//Traversing queue with for-each loop
        for(Book2 b:queue){
            System.out.println(b.bookId+" "+b.name+" "+b.author+" "+b.publisher +""+b.quantity);
        }
        // Removing a book from the queue
        queue.remove();
        System.out.println("After removing one book record:");
// Adding another book into the queue
        queue.add(new Book2(555, "Classic Data Structures", "D. Samanta", "Prentice Hall", 9));
        for(Book2 b:queue){
            System.out.println(b.bookId+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}

//6.COPYING A COLLECTION IN A QUEUE
/* To convert a Java array to Queue using addAll() method defined in the
Collection class. */
 class ArrayToQueue {
    public static void main(String[] args) {
// Create an array of String objects
        String city[] = {"CCU", "DEL", "BLR", "MUM", "GAU"};
// Declare a queue
        Queue<String> queue = new PriorityQueue<String>();
// Copying the array to Queue
        Collections.addAll(queue, city);
// Printing the array
        System.out.println("Array :" + city);
        System.out.println();
// Printing the queue
        System.out.println("Queue :" + queue);
    }
}
//6.2: QUEUE TO OTHER COLLECTION CONVERSION
/* To copy a Queue object to an array using toArray method defined in the
Collection class. */
class QueueToArray {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>(); // Creating a queue
        queue.add("Jio");
                queue.add("123");
        queue.add("John");
        queue.add("Jaya");
        queue.add("Jim");
        queue.add("!@#$%");
// Copying the queue to an array of string objects
        String friends[] = queue.toArray(new String[queue.size()]);
        System.out.println(Arrays.toString(friends)); // Printing the array
        System.out.println();
        System.out.println("Queue :" + queue); // Printing the queue
    }
}

//7.ACCESSING ELEMENTS IN QUEUW
/* There are two methods in Queue interface: element() and peek(), which are used
to access an element in a queue. Following two examples illustrates the working
of the two methods. This is an example of accessing with element() method. */
class QueueElementAccess {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.add("One");
        System.out.println(queue.element());
        System.out.println(queue);
        queue.clear();
        System.out.println(queue.element()); // Throws an exception
    }
}
//7.2
/* Queue.peek(): The peek() operation is used to retrieve an element from the head
of the queue, without removing it. If it performs the operation successfully, it
returns the head element of the queue. Otherwise, it returns null value. */
class QueuePeekOperation {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.add("One");
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.clear();
        System.out.println(queue.peek()); // Returns null value
    }}

    //8...
/*
Java JCF queue categories::---
-->In Java, we can find many queue implementations. We can broadly categorize
them into the following two types:
1. Bounded Queues
2. Unbounded Queues
-->In other ways, we can broadly categorize them into the following two types:
1. Blocking queues
2. Non-blocking queues
All queues which implement BlockingQueue interface are blocking queues: otherwise,
non-blocking queues.
BlockingQueues blocks until it finishes it’s job or time out.
Further, queues are Queue, Deque

-->In addition to Queue’s two forms of operations, BlockingQueue’s supports two more forms as shown
below.
Operation   Throws exception       Special value        Blocks      Times out
Insert -->      add(e)              offer(e)            put(e)   offer(e, time, unit)
Remove -->      remove()            poll()              take()   poll(time, unit)
Examine -->     element()           peek()              N/A         N/A
* * */

/*
9.ARRAY DEQUEUE CLASS:
The ArrayDeque class extends AbstractCollection and implements the Deque interface.
It has no method of its own. ArrayDeque creates a dynamic array and has no capacity
restrictions.
ArrayDeque is a generic class that has this declaration:
class ArrayDeque<E>
Here, E specifies the type of objects stored in the collection.
**/
class ArrayDequeDemo {
    public static void main(String args[]) {
// Create an array deque.
        ArrayDeque<String> adq = new ArrayDeque<String>();
        adq.push("A");// Use an ArrayDeque like a stack.
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");
        System.out.print("Popping the stack: ");
        while (adq.peek() != null)
            System.out.print(adq.pop() + " ");
        System.out.println();
    }
}