package QUEUE;

public class KQueuesArray {
    int k,n;
    int free;//Together with k queues, a stack of free slots in arr[] is also maintained. The top of this stack is stored in a variable ‘free’.
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;

KQueuesArray(int k,int n){
    this.k = k;//k is the number of queues
    this.n = n;//
    this.arr = new int[n];//Here arr[] is the actual array that stores k stacks.Together with k queues, a stack of free slots in arr[] is also maintained. The top of this stack is stored in a variable ‘free’.
    this.front = new int[k];//total fronts available wil be k
    this.rear = new int[k];//total rear elements will be k as k queues are present
    this.next = new int[n];//This is of size n and stores indexes of next item for all items in array arr[].

    // Initialize all queues as empty
    for(int i= 0; i< k; i++) {
        front[i] = rear[i] = -1;
    }

    // Initialize all spaces as free
    free = 0;
    for(int i= 0; i< n-1; i++) {
        next[i] = i+1;
    }
    next[n-1] = -1;
}

    // To check whether queue number 'i' is empty or not
    private boolean isEmpty(int i) {
        return front[i] == -1;
    }
    // To dequeue an from queue number 'i' where i is from 0 to k-1
    private boolean isFull(int i) {
        return free == -1;
    }
// // To enqueue an item in queue number 'j' where j is from 0 to k-1
    private void enqueue(int item,int j){
    if (isFull(j)) {
        System.out.println("Queue Overflow");
        return;
    }
    int nextFree = next[free];

    if (isEmpty(j)){
        rear[j] = front[j] = free;
    }else {
        // Update next of rear and then rear for queue number 'j'
        next[rear[j]] = free;
        rear[j] = free;
    }
        next[free] = -1;

        // Put the item in array
        arr[free] = item;

        // Update index of free slot to index of next slot in free list
        free = nextFree;


}

    private int dequeue(int i){
    if (isEmpty(i)){
        System.out.println("Queue Underflow");
        return Integer.MIN_VALUE;
    }
    // Find index of front item in queue number 'i'
        int frontIndex = front[i];

        // Change top to store next of previous top
        front[i] = next[frontIndex];

        // Attach the previous front to the beginning of free list
        next[frontIndex] = free;
        free = frontIndex;

        return arr[frontIndex];

    }


    public static void main(String[] args)
    {
        // Let us create 3 queue in an array of size 10
        int k = 3, n = 10;
        KQueuesArray ks=  new KQueuesArray(k, n);


        // Let us put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);

        // Let us put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);

        // Let us put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);
        ks.enqueue(7, 0);   ks.enqueue(7, 0);
        System.out.println("Dequeued element from queue 2 is " +
                ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " +
                ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " +
                ks.dequeue(0) );

    }

}

/*
* Create a data structure kQueues that represents k queues. Implementation of kQueues
* should use only one array, i.e., k queues should use the same array for storing elements.
* Following functions must be supported by kQueues.

enqueue(int x, int qn) –> adds x to queue number ‘qn’ where qn is from 0 to k-1
dequeue(int qn) –> deletes an element from queue number ‘qn’ where qn is from 0 to k-1
* */
