package QUEUE;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCacheImplementation {

 /*   Queue<Integer> q = new LinkedList<>();
    HashSet<Integer> h = new HashSet<>();
    static int cache_size = 0;

    void update(Queue q,int item){
        if (h.contains(item)){
            q.remove(item);
            q.add(item);
        }
        q.remove();
        q.add(item);
    }
*/
    // store keys of cache
    private Deque<Integer> doublyQueue;

    // store references of key in cache
    private HashSet<Integer> hashSet;

    // maximum capacity of cache
    private final int CACHE_SIZE;

    LRUCacheImplementation(int capacity) {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    /* Refer the page within the LRU cache */
    public void refer(int page) {
        if (!hashSet.contains(page)) {
            if (doublyQueue.size() == CACHE_SIZE) {
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        else {/* The found page may not be always the last element, even if it's an
               intermediate element that needs to be removed and added to the start
               of the Queue */
            doublyQueue.remove(page);
        }
        doublyQueue.push(page);
        hashSet.add(page);
    }
public void display(){
    Iterator<Integer> itr = doublyQueue.iterator();
    while (itr.hasNext()){
        System.out.print(itr.next() + " ");
    }
}

    public static void main(String[] args) {
        LRUCacheImplementation cache = new LRUCacheImplementation(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        cache.refer(3);
        cache.display();
    }

}
/*
How to implement LRU caching scheme? What data structures should be used?
We are given total possible page numbers that can be referred. We are also given cache
(or memory) size (Number of page frames that cache can hold at a time). The LRU caching
scheme is to remove the least recently used frame when the cache is full and a new page
is referenced which is not there in cache. Please see the Galvin book for more details
(see the LRU page replacement slide here).
* */































