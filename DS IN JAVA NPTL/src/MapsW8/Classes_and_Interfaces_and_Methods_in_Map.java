package MapsW8;

public class Classes_and_Interfaces_and_Methods_in_Map {
    /*
     9.INTERFACES:
  Interface        Description
Map ==>Maps unique keys to values. The interface is generic and it is defined as interface Map<K, V>,
        where K specifies the type of keys, and V specifies the type of values.
Map.Entry ==> Describes an element (a key/value pair) in a map. This is an inner class of Map.
NavigableMap ==>Extends SortedMap to handle the retrieval of entries based on closest match searches.
SortedMap ==>Extends Map so that the keys are maintained in ascending order.

    10.CLASSES :
Class               Description
AbstractMap==> Implements most of the Map interface.
EnumMap ==> Extends AbstractMap for use with enum keys.
HashMap ==> Extends AbstractMap to use a hash table.
TreeMap ==> Extends AbstractMap to use a tree.
LinkedHashMap ==> Extends HashMap to allow insertion-order iterations.
IdentityHashMap ==> Extends AbstractMap and uses reference quality when comparing documents.
WeakHashMap ==> Extends AbstractMap to use a hash table with weak key

    11.METHODS OF MAP INTERFACE==>
    Method Description
void clear() ==>Removes all key/value pairs from the invoking map.
default V compute(Kk,BiFunction<?super K,? superV,? extends V>func)
        ==>Calls func to construct an ew value. If func returns non-null, the new
    key/value pair is added to the map, any pre existing pairing is removed, and
    the new value is returned. If func returns null, any pre existing pairing is
    removed, and null is returned.
default V computeIfAbsent(K k,Function<?super K, ? Extends V>func)
        ==>Returns the value associated with the key k. Otherwise, the value is
        constructed through a call to func and the pairing is entered into the map and
        the constructed value is returned. If no value can be constructed, null is returned.
default V compute IfPresent(K k, BiFunction<? superK,? Super V,? Extends V>func)
        ==>If k is in the map, a new value is constructed through a call to func and the new
    value replaces the old value in the map. In this case, the new value is returned.
    If the value returned by func is null, the existing key and value are removed
    from the map and null is returned.
boolean containsKey(Object k) ==> Returns true if the invoking map contains k as a key.
        Otherwise, returns false

boolean containsValue(Object v) ==>Returns true if the map contains v as a value. Otherwise, returns false.
Set<Map.Entry<K,V>>entrySet() ==>Returns a Set that contains the entries in the map. The set contains objects of
type Map.Entry. Thus, this method provides a set-view of the invoking map.
boolean equals(Object obj) ==>Returns true if obj is a Map and contains the same entries.Otherwise,
    returns false.
default void forEach(BiConsumer<? Super K,? Super V>action) ==> Executes action on each element in the invoking map.
        AconcurrentModificationException will be thrown if an element is removed during the process.
V get(Object k) ==> Returns the value associated with the keyk. Returns Null if the key is not
found.
default V get (Object k,V defVal)==> Returns the value associated with k if it is in the map. Otherwise, defVal is
returned.
int hashCode() ==>Returns the hash code for the invoking map.
boolean isEmpty() ==>Returns true if the invoking map is empty. Otherwise, returns fals

default V putIfAbsent(K k,V v) ==>Inserts the key/value pair into the invoking map if this pairing is not already
        present or if the existing value is null. Returns the old value. The null value is
        returned when previous mapping exists, or the value is null.
V remove(Object k) ==>Removes the entry whose key equals k.
default boolean remove(Object k,Object v) ==>If the key/value pair specified by k and v is in the invoking map, it is removed
        and true is returned. Otherwise, false is returned.

default Boolean replace(K k, V oldV, V newV) ==> If the key/value pair specified by k and oldV is in the invoking map, the value is
        replaced by newV and true is returned. Otherwise, false is returned.
default V replace(K k,V v) ==> If the key specified by k is in the invoking map, its value is set to v and the
        previous value is returned. Otherwise, null is returned.

default void replaceAll(BiFunction<?Super K,? Super V,? Extends V>func) ==>Executes func on each element of the invoking map, replacing the element with
        the result returned by func. A ConcurrentModificationException will be thrown if an element is removed during the process.
int size() ==>Returns the number of key/value pairs in the map.
Collection<V>values() ==>Returns a collection containing the values in the map. This method provides a
        collection view of the values in th em


    * * */
}
