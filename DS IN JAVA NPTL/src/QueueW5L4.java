public class QueueW5L4 {
    /*
1.INTRO:
Queue is an ordered collection of homogeneous data elements where, insertion and deletion
operations take place at two extreme ends.Queue follows FIFO (First In First Out) property

2.MEMORY REPRESSENTATION
Array representation
--A one-dimensional array is used and it is a better choice IF a queue of fixed size is required
 --A double linked list is used which provides a queue whose size can vary during processing.

3.OPERATIONS OF QUEUE:
--Enqueue To insert an item into a queue
--Dequeue To remove an item from a queue
--Status To know the present state of a queue

4.CIRCULAR QUEUE
Algorithm EnqueueCQ
1. If (FRONT = 0) then // When queue is empty
2. FRONT = 1
3. REAR = 1
4. CQ[FRONT] = ITEM
5. Else // Queue is not empty
6. next = (REAR MOD LENGTH) + 1
7. If (next ¹ FRONT) then // If queue is not full
8. REAR = next
9. CQ[REAR] = ITEM
10. Else
11. Print “Queue is full”
12. EndIf
13. EndIf
14. Stop

.................. ............. ................
Algorithm DequeCQ
1. If (FRONT = 0) then
2. Print “Queue is empty”
3. Exit
4. Else
5. ITEM = CQ[FRONT]
6. If (FRONT = REAR) then // If the queue contains single element
7. FRONT = 0
8. REAR = 0
9. Else
10. FRONT = (FRONT MOD LENGTH) + 1
11. EndIf
12. EndIf
13. Stop


5.STATUS OP
Status operation of circular queue
.................. ............. ................
With this principle the two states of the queue regarding its
empty or full will be decided as:
Circular queue is empty
FRONT = 0
REAR = 0
Circular queue is full
FRONT = (REAR MOD LENGTH) + 1
Principle:
• Both pointers will move in clockwise direction. This is controlled by
the MOD operation; for example, if the current pointer is at i then
shift to the next location will be i MOD LENGTH + 1, 1 ≤ i ≤ LENGTH
(where LENGTH is the queue length). Thus, if i = LENGTH (that is at
the end), then next position for the pointer is 1.
NPTEL
DEQueue:
Double Ended Queue


6.DEQUEUE
 Another variation of the queue is known as dequeue (pronounced as ‘deck’).
• The term dequeue has originated from double ended queue.
• In DEqueue, both insertion and deletion operations can be made at either end of the structure.
--Input restricted
-Output restricted

7.APLICATIONS:Queues are extensively used in Operating System
1. Simulation
2. CPU scheduling in multiprogramming environment
3. Process scheduling---DISCUSSED BELOW

    * * */
}
//1.DEFINING QUEUE USING ARRAY:

class QueueA<T>{ //Defining a GENERIC Class
    T[] data; //name of array used for storing
    int front, rear; //two pointers used in a queue
    int length; // 0 - n-1

    QueueA(T[] a){
        data = a; //data can be null also
        front = 0; //Empty queue condition ofr front
        rear = -1; //empty queue conditoin for rear
        length = a.length;
    }
/* The methods enqueue(), dequeue(), isEmpty(), printQueue() are to be defined here. */

//1.This part of the program includes the definition of the enqueue() method
// Defining the insert operation
void enque(T a){
    if(rear>=length-1){
        System.out.println("Queue Overflow");
    }
    else {
        rear++;
        data[rear] = a;
    }
}

//2.This part of the program includes the definition of the dequeue() method
// Defining the delete operation
T deque(){
    T x = null; //i.e initially it will return null if QUEUE IS EMPTY!
    if(isEmpty()){
        System.out.println("Queue Underflow");
        return null;
    }
    else {
        x = data[front];
        front++;
        return x;
    }
}

//3.This part of the program includes the definition of the isEmpty() method
boolean isEmpty(){
    if(front>rear){
        return true;
    }
    else{
        return false;
    }
}

//4.This part of the program includes the definition of the printQueue() method
// Defining an operation to print an entire queue content
void printQueue() {
    if(!isEmpty()) {
        for(int i = front;i<=rear;i++) {
            System.out.print(data[i] + " ");
        }
    }
    System.out.println();
}
} // End of the definition of the class QueueA

//1.2 DRIVER PROGRAM--->
/* This is the main program, illustration the usage of the class defined. You
should include the package, where this program is stored. */
class QueueAImplementationDemo {
    public static void main(String[] args){
        Integer arr[] = new Integer[2];
        QueueA<Integer> q = new QueueA<Integer>(arr);
        q.enque(1);
        q.printQueue();
        q.enque(2);
        q.printQueue();
        q.enque(3);
        q.printQueue();
        q.deque();
        q.printQueue();
        q.deque();
        q.printQueue();
        q.deque();
        q.printQueue();

        System.out.println("With Strings: ");

        String arr2[] = new String[2];
        QueueA<String> q2 = new QueueA<String>(arr2);
        q2.enque("hello");
        q2.printQueue();
        q2.enque("hy");
        q2.printQueue();
        q2.enque("how");
        q2.printQueue();
        q2.deque();
        q2.printQueue();
        q2.deque();
        q2.printQueue();
        q2.deque();
        q2.printQueue();
    }
} // End of the demo class

//2.LINKEDLST IMPLEMENTATION OF QUEUE
// This program shows how a queue can be defined using a linked list
/* This program uses linked list related implementation; so, include the
directory, where all those programs are defined (e.g. jLLPacakage folder. */
class QueueL<T> {
    JLinkedList<T> front, rear;
    QueueL(){
        front = new JLinkedList<T>();
        rear = front;
    }
    /* The methods enqueue(), dequeue(), isEmpty(), printQueue() are to be defiNED here*/

    //1.This part of the program includes the definition of the enqueue() method
    void enque(T a){ //No need to check whether LL is full, as LL can never be full
        this.rear.insertEnd(a); // Method is in jLLPackage
    }

    //2.This part of the program includes the definition of the dequeue() method
    T deque(){
        T data = null;
        if(!isEmpty()){
            this.front.deleteFront(); // Method is in jLLPackage
        }
        else {
            System.out.print("Queue Underflow");
        }
        return null;
    }

    //3.This part of the program includes the definition of the isEmpty() method
    boolean isEmpty() {
        if(front == null){
            return true;
        }
        else{
            return false;
        }
    }

    //4.This part of the program includes the definition of the printQueue() method
    // Defining an operation to print an entire queue content
    void printQueue(){
        if(this.front == null){
            System.out.println("Queue is Empty");
        }
        else{
            this.front.printList();
        }
    }
}
//DRIVER PROGRAM FOR LL IMP FOR QUEUE--->
/* This is the main program, illustration the usage of the class defined. You should
include the package, where this program is stored. */
class QueueLImplementationDemo {
    public static void main(String[] args) {
        QueueL<Integer> q = new QueueL<Integer>();
        q.enque(1);
        q.printQueue();
        q.enque(2);
        q.printQueue();
        q.enque(3);
        q.printQueue();
        q.deque();
        q.printQueue();
        q.deque();
        q.printQueue();
        q.deque();
        q.printQueue();
    }
} // End of the demo class


//3.1.PROCESS SCHEDULING APPLICATION OF QUEUE -First come first serve --> fcfs
    /* The following is the class definition to define a process. */
class Process {
    int index;
    int time;
    Process(int i,int t){
        time = t;
        index = i;
    }
    void print()
    {
        System.out.println("Job:"+ this.index + " time:" + this.time);
    }
} // End of the process class

//3.2 The following program is the main class which schedule process according to their
//priorities.
class QueueApplicationDemo {
    public static void main(String[] args) {
        Process arr1 = new Process(1,5);
        Process arr2 = new Process(2,15);
        Process arr3 = new Process(3,10);
        Process arr4 = new Process(4,35);
        Process done;
        int totaltime = 0;
        QueueL<Process> fcfs = new QueueL<Process>();
        fcfs.enque(arr1);
        fcfs.enque(arr2);
        fcfs.enque(arr3);
        fcfs.enque(arr4);
        System.out.println("Job Entering complete");
        done = fcfs.deque();
        done.print();
        totaltime+=done.time;
        done = fcfs.deque();
        done.print();
        totaltime+=done.time;
        done = fcfs.deque();
        done.print();
        totaltime+=done.time;
        done = fcfs.deque();
        done.print();
        totaltime+=done.time;
        System.out.println("Total time taken is:" + totaltime);
    }
} // End of the driver class

























