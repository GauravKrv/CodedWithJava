package MapsW8;

import java.util.*;

public class Tree_Enum_LinkedHash_ConcurrMaps {

    /*
    TreeMap class defines the following constructors:
Constructor                         Description
TreeMap( ) ==>The first form constructs an empty tree map that will be sorted by using the natural order of its keys.
TreeMap(Comparator<? super K> comp) ==> The second form constructs an empty tree-based map that will be
                                        sorted by using the Comparator comp. (Comparators are discussed later in this chapter.)
TreeMap(Map<? extends K, ? extends V> m) ==>The third form initializes a tree map with the entries from m, which
                                        will be sorted by using the natural order of the keys..
TreeMap(SortedMap<K, ? extends V>sm) ==>The fourth form initializes a tree map with the entries from sm,
                                        which will be sorted in the same order as sm.
===>TreeMap has no map method beyond those specified by the NavigableMap interface and the
AbstractMap class.

    2.All the operations you have learned for the HashMap class is equally applicable with
    TreeMap class.
<===============================================================================>
LINKED HASHMAP----------------------
1.LinkedHashMap defines the following constructors:
Constructor                             Description
LinkedHashMap( ) ==>It is a default constructor.
LinkedHashMap(Map<? extends K, ? extends V> m) ==>This constructor initializes the
                                LinkedHashMap with the elements from m.
LinkedHashMap(int capacity) ==>The third form initializes the capacity.
LinkedHashMap(int capacity, float fillRatio) ==>initializes both capacity and fill ratio.
                                    The default capacity is 16. The default ratio is 0.75.
LinkedHashMap(int capacity, float fillRatio, boolean order) ==>Itallows you to specify
whether the elements will be stored in the linked list by insertion order, or by order
 of last access. If Order is true, then access order is used. If order is false,
 then insertion order is used

2.MEHOD
protected boolean removeEldestEntry(Map.Entry <K, V> e)==>
This method is used keep a track of whether the map removes any
eldest entry from the map. So each time a new element is added to the
LinkedHashMap, the eldest entry is removed from the map. This
method is generally invoked after the addition of the elements into the
map by the use of put() and putAll() method. This method is called by
put( ) and putAll( ). The oldest entry is passed in e. By default, this
method returns false and does nothing. However, if you override this
method, then you can have the LinkedHashMap remove the oldest
entry in the map. To do this, have your override return true. To keep
the oldest entry, return false









    *
    * * * */
}
//1.Creating a TreeMap
// Illustrates the creation of a map container
class TreeMapDemo {
    public static void main(String args[]) {
// Create a tree map.
        TreeMap<String, Double> tm = new TreeMap<String, Double>();//K,O
// Put elements to the map.

        tm.put("John Doe", new Double(3434.34));
        tm.put("Tom Smith", new Double(123.22));
        tm.put("Jane Baker", new Double(1378.00));
        tm.put("Tod Hall", new Double(99.22));
        tm.put("Ralph Smith", new Double(-19.08));
// Get a set of the entries.
        Set<Map.Entry<String, Double>> set = tm.entrySet();//To create a collection of set
// Display the elements.
        for(Map.Entry<String, Double> me : set) {//Traversing the set created
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
// Deposit 1000 into John Doe's account.
        double balance = tm.get("John Doe");
        tm.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance: " + tm.get("John Doe"));
    }
}
//<======================================LINKED HASH MAP===============================>
/* This program illustrates the creation of a Map object using LinkedHashMap class */
class LinkedHashMapDemo {
    private static final int MAX = 6; // Refers to the max size of the map

    public static void main(String args[]) {
// Creating the linked hashmap and implementing removeEldestEntry() to MAX size
        LinkedHashMap<Integer, String> lhm =
                new LinkedHashMap<Integer, String>() {
                    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                        return size() > MAX;//if size of list is greater than MAX then
                        // eldest[youngest] entry will be removed from the list
                    }
                };
        // Adding elements using put()
        lhm.put(0, "Welcome");
        lhm.put(1, "To");
        lhm.put(2, "The");
        lhm.put(3, "World");
        lhm.put(4, "Of");
        lhm.put(5, "Java");
        System.out.println("" + lhm);
// Adding more elements
        lhm.put(6, "Joy with Java");
// Displying the map after adding one more element
        System.out.println("" + lhm);
// Adding more elements
        lhm.put(7, "Hello");//1 will be popped
// Displying the map after adding one more element
        System.out.println(" " + lhm);
/*
Note:
• This method allows the map to modify itself as directed by its return value. Although the method
is permitted to modify the map directly, if it does so, it must return false which will be indicative
of the fact that the map should not attempt any further modification leading to ambiguity. The
effects of returning true after modifying the map from within this method are unspecified.
• This is very useful when the map represents a cache where it allows the map to reduce memory
consumption by deleting stale entries one after anothe


<=======================================ENUM MAP CLASS===============================>
1.CONSTRUCTORS
EnumMap(Class<K>kType) ==>This constructor creates an empty EnumMap of type kType.
EnumMap(Map<K, ? extends V> m) ==>This constructor creates an EnumMap map that contains the same
                                    entries as m.
EnumMap(EnumMap<K, ? extends V>em) ==>To create an EnumMap initialized with the values in em
Note:
• There are no class of its own defined in EnumMap class

        2.NOTE
Note:
• EnumMap class is a member of the Java Collection Framework and is not synchronized.
• EnumMap is ordered collection and they are maintained in the natural order of their keys
(natural order of keys means the order on which enum constant are declared inside
enum type )
• It’s a high performance map implementation, much faster than HashMap.
• All keys of each EnumMap instance must be keys of a single enum type.
• EnumMap doesn’t allow null key and throw NullPointerException, at same time null
values are permitted.
N



* * */
    }
}

//2.MAP CONTAINER WITH USER DEFINED DATA:
/* This example illustrates how a map container will be with objects of Book
class. */
class Book {
    int id;
    String name,author,publisher;
    int quantity;
    public Book(int id, String n, String a, String p, int q){
        this.id = id;
        name = n;
        author = a;
        publisher = p;
        quantity = q;
    }
}
//DRIVER CLASS
class MapBookDataExample {
    public static void main(String[] args) {
//Creating map of Books
        Map<Integer,Book> map=new LinkedHashMap<Integer,Book>();//K=Integer,Value=Book type
//Creating Books
        Book b1=new Book(101,"Python","Ponting","Oxford",8);
        Book b2=new Book(102,"Java","Spielberg","McGraw Hill",4);
        Book b3=new Book(103,"C++","Galvin","Wiley",6);
//Adding Books to map
        map.put(2,b2);
        map.put(1,b1);
        map.put(3,b3);
//Traversing map
        for(Map.Entry<Integer, Book> entry : map.entrySet()){
            int key = entry.getKey();
            Book b = entry.getValue();
            System.out.println(key+" Details:");
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
}
//<=========================================================================>
/* This Java program illustrates working of EnumMap and its functions. */

 class EnuMapExample {
    public enum SIZE {S, M, L, X };//Defining an enum datatype named SIZE,like an array
    public static void main(String args[]) {
// Creating EnumMap in java with key as enum type STATE
        EnumMap<SIZE, String> enuMap = new EnumMap<>(SIZE.class);//K=SIZE,V=String
//Putting values inside EnumMap in Java
// Inserting Enum keys different from their natural order
        enuMap.put(SIZE.S, "Children");
        enuMap.put(SIZE.M, "Young");
        enuMap.put(SIZE.L, "Aged");
        enuMap.put(SIZE.X, "Old");
// Printing size of EnumMap in java
        System.out.println("Size of EnumMap : "+ enuMap.size());
// Printing Java EnumMap
        System.out.println("EnumMap: "+ enuMap);
// Retrieving value from EnumMap in java
        System.out.println("Key : "+ SIZE.S +", Value: " + enuMap.get(SIZE.S));
    }
}
//SYNCHRONISED THREAD-SAFE MAP--Concurrent Map
class HashMapBulkOperationDemo1 {
    public static void main(String args[]) {
// Create two map object containers.doing thread safe implementatoin for it
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
// Creatin a map
        map.put(400, "Bad Request");
        map.put(304, "Not Modified");
        map.put(200, "OK");
        map.put(301, "Moved Permanently");
        map.put(500, "Internal Server Error");
        Set<Integer>keySet = map.keySet();
        synchronized(map) {
            //Performing operations in synchronised manner---
            Iterator<Integer> iterator = keySet.iterator();
            while(iterator.hasNext()) {
                Integer key = iterator.next();
                String value = map.get(key);
                System.out.println("value->"+value);
            }
        }
    }
    /*
    Note:
• You should manually synchronize the map when iterating over any of its collection views.
• If you use your own type for the key and value (e.g. Student or Employee), the key class and
value class must implement the equals() and hashCode() methods properly so that the map can
look up them correctly

    * * */
}