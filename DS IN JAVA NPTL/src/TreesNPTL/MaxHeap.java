package TreesNPTL;

public class MaxHeap <T extends Comparable<T>> {
    int size;
    int maxsize;
    private static final int FRONT = 1;
    private T[] Heap;
    MaxHeap(T[] arr,T node){
        this.maxsize = arr.length;
        this.size = 0;
        Heap = arr;
        Heap[0] = node;

    }

    private int parent(int pos){ //Will return parent position os the pos
        return pos/2;
    }
   private int rightChild(int pos){ //Will return rightChild position os the pos
        return (pos*2+1);
    }
    private int leftChild(int pos){ //Will return leftChild position os the pos
        return (pos*2);
    }

    private boolean isLeaf(int pos){
        if (pos>=size/2 && pos<=size ){
            return true;
        }else {
            return false;
        }
    }

    public void print(){

        for (int i =1;i<=size/2;i++){
            System.out.print(" PARENT "+i+" : " + Heap[i]
                    + "| LEFT CHILD at "+2*i+" : " + Heap[2 * i]
                    + "| RIGHT CHILD at "+(2*i+1)+" :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void maxHeapyfy(int pos){
        if (!isLeaf(pos)){
            if (Heap[pos].compareTo(Heap[leftChild(pos)])<0 ||Heap[pos].compareTo(Heap[rightChild(pos)])<0  ){
                if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)])>0){
                    swap(pos,leftChild(pos));
                    maxHeapyfy(leftChild(pos));
                }
                 else {
                    swap(pos,rightChild(pos));
                    maxHeapyfy(rightChild(pos));
                }
            }
        }

    }

    private void swap(int fpos, int spos) {
        T tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;

    }

    public void insert(T element){
        if(size>maxsize){
            return;
        }
        Heap[++size] =  element;
        int current = size;
        if (Heap[current].compareTo(Heap[parent(current)])>0){
            swap(current,parent(current));
        }
        //current = parent(current);
    }

    public T remove(){
        T popped = Heap[FRONT]; //first elem is stored in a variable,
        Heap[FRONT] = Heap[size--];//last elem is inserted in first
        maxHeapyfy(FRONT);
        return popped;
    }
    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapyfy(pos);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("The Max Heap is ");
        Integer[] a = new Integer[15];
        MaxHeap maxHeap = new MaxHeap(a , 15 );
//minHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();
        maxHeap.print();

        System.out.println("The Max val is " + maxHeap.remove());//will not print 3
    } // End of all methods of this program




}
