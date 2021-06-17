package HASHING;

public class RehashingAndLoafFactor {
    /*
    How hashing works:
For insertion of a key(K) – value(V) pair into a hash map, 2 steps are required:

==>K is converted into a small integer (called its hash code) using a hash function.
The hash code is used to find an index (hashCode % arrSize) and the entire linked list at that
    index(Separate chaining) is first searched for the presence of the K already.
==>If found, it’s value is updated and if not, the K-V pair is stored as a new node in the list.

Complexity and Load Factor

For the first step, time taken depends on the K and the hash function.
For example, if the key is a string “abcd”, then it’s hash function may depend on the length of the string.
But for very large values of n, the number of entries into the map, length of the keys is almost negligible in comparison to
n so hash computation can be considered to take place in constant time, i.e, O(1).

For the second step, traversal of the list of K-V pairs present at that index needs to be done. For this, the worst case may be that all the n entries are at the same index.
So, time complexity would be O(n). But, enough research has been done to make hash functions uniformly distribute the keys in the array so this almost never happens.

=====>>So, on an average, if there are n entries and b is the size of the array there would be n/b entries on each index. This value n/b is called the load factor that represents
the load that is there on our map.
This Load Factor needs to be kept low, so that number of entries at one index is less and so is the complexity almost constant, i.e., O(1).

Rehashing:
As the name suggests, rehashing means hashing again. Basically, when the load factor increases to more than its pre-defined value (default value of load factor is 0.75),
 the complexity increases. So to overcome this, the size of the array is increased (doubled) and all the values are hashed again and stored in the new double sized array to maintain a low
  load factor and low complexity.

==>Why rehashing?
Rehashing is done because whenever key value pairs are inserted into the map, the load factor increases, which implies that the time complexity also increases as explained above.
 This might not give the required time complexity of O(1).

Hence, rehash must be done, increasing the size of the bucketArray so as to reduce the load factor and the time complexity.

==>How Rehashing is done?
Rehashing can be done as follows:

For each addition of a new entry to the map, check the load factor.
If it’s greater than its pre-defined value (or default value of 0.75 if not given), then Rehash.
For Rehash, make a new array of double the previous size and make it the new bucketarray.
Then traverse to each element in the old bucketArray and call the insert() for each so as to insert it into the new larger bucket array.





    * */

}
