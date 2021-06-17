package HASHING;

public class SeperateChaining_2 {

}

/*THEORY :
What is Collision?
Since a hash function gets us a small number for a key which is a big integer or string,
 there is a possibility that two keys result in the same value. The situation where a
 newly inserted key maps to an already occupied slot in the hash table is called
 collision and must be handled using some collision handling technique.

 How to handle Collisions?
There are mainly two methods to handle collision:
1) Separate Chaining
2) Open Addressing\

Separate Chaining:
The idea is to make each cell of hash table point to a linked list of records that have
same hash function value.

Advantages:
1) Simple to implement.
2) Hash table never fills up, we can always add more elements to the chain.
3) Less sensitive to the hash function or load factors.
4) It is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.

Disadvantages:
1) Cache performance of chaining is not good as keys are stored using a linked list. Open addressing
provides better cache performance as everything is stored in the same table.
2) Wastage of Space (Some Parts of hash table are never used)
3) If the chain becomes long, then search time can become O(n) in the worst case.
4) Uses extra space for links.

Performance of Chaining:
Performance of hashing can be evaluated under the assumption that each key is equally likely to be
 hashed to any slot of table (simple uniform hashing).
m = Number of slots in hash table
 n = Number of keys to be inserted in hash table
Load factor α = n/m

 Expected time to search = O(1 + α)

 Expected time to delete = O(1 + α)

Time to insert = O(1)
Time complexity of search insert and delete is
 O(1) if  α is O(1)













* */
