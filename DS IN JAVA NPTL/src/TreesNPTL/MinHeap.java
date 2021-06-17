package TreesNPTL;

public class MinHeap<T extends Comparable<T>> {
    //same numeric ,string can be coparable concept
    private T[] Heap;//Heap will be an array
    private int size;//Total elem present in currHeap
    private int maxsize;//Capacity
    private static final int FRONT = 1;//It tells that index start from 1
    public MinHeap(T[] arr , T node)//Heap obj will be created with an array and a single Node
    {
        this.maxsize = arr.length;
        this.size = 0;
        Heap = arr;
        Heap[0] = node;
    }
// Methods of this class are defined next ...to be added here.

    //1.AUXILLIARY METHODS :
    // Method to return the position of the parent for the child node currently at postn "pos"
    private int parent(int pos)
    {
        return pos / 2;
    }

    // Function to return the position of the right child for the node currently at pos
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Method to return the position of the left child for the node currently at pos
    private int leftChild(int pos)
    {
        return (2 * pos);
    }

  //Function that returns true if the passed node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Function to swap two nodes of the heap as we do in heap
    private void swap(int fpos, int spos)
    {
        T tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT "+i+" : " + Heap[i]
                    + "| LEFT CHILD at "+2*i+" : " + Heap[2 * i]
                    + "| RIGHT CHILD at "+(2*i+1)+" :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    //2.HEAPIFY METHOD
    // Function to heapify the node at pos
    private void minHeapify(int pos) {
// If the node is a non-leaf node and greater than any of its child then only this works
        if (!isLeaf(pos)) {  //
            if (Heap[pos].compareTo(Heap[leftChild(pos)]) > 0
                    || Heap[pos].compareTo(Heap[rightChild(pos)]) > 0) { //If parent element is > thn left or right child
// Swap with the left child and heapify the left child
                if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) < 0) {  //==>Left Chld is smaller than Right so swap from left
                    swap(pos, leftChild(pos)); //Then swap from left child
                    minHeapify(leftChild(pos));  //Then again heapify the left child
                }
// Swap with the right child and heapify the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    //3.INSERTION
    // Function to insert a node into the heap
    public void insert(T element)
    {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;
        while (Heap[current].compareTo(Heap[parent(current)]) < 0 ){  //Here compareTo method comesfrom comparator class, which is used to compare 2 Strings,float,double,int,etc.
            swap(current, parent(current));//Swap the child to parent till insertedNode reaches
            //exact place
            current = parent(current);
        }
    }
    //4.DELETION
    // Function to remove and return the minimum element from the heap
    public T remove()
    {
        T popped = Heap[FRONT]; //Here indexing is done from 1
        Heap[FRONT] = Heap[size--];//REMOVED FROM FRONT BECOZ TO MAINTAIN THE SORTED ORDER.
                                    //ALSO THE PARENT OF HEAP IS ALWAYS AT THE STARTING INDEX IN A HEAP
        minHeapify(FRONT);
        return popped;
    }

    //5.BUILDING MINHEAP
    // Function to build the min heap using the minHeapify
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

        //6.MASTER PROG
        public static void main(String[] args)
        {
            System.out.println("The Min Heap is ");
            Integer[] a = new Integer[15];
            MinHeap minHeap = new MinHeap(a , 15 );
//minHeap.insert(5);
            minHeap.insert(3);
            minHeap.insert(17);
            minHeap.insert(10);
            minHeap.insert(84);
            minHeap.insert(19);
            minHeap.insert(6);
            minHeap.insert(22);
            minHeap.insert(9);
            minHeap.minHeap();
            minHeap.print();

            System.out.println("The Min val is " + minHeap.remove());//will not print 3
        } // End of all methods of this program
    }
 // End of the program

class ArrayTTry{
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i =1;i<10;i++){
            arr[i] = i;
        }
        for (int i =1;i<10;i++){
            System.out.println("Element at index"+i+ " = "+arr[i]);
        }
        System.out.println();
        System.out.println("Element at index"+0+ " = "+arr[0]);
    }
}
