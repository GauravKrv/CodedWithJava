package MapsW8;

import java.util.*;

public class HashMapFullConcept {
    /*
    ---------------------HASHMAP CLASS-----------------------------------
    1.CONSTRUCTOR IN HASHMAP CLASS
    Constructor Description
HashMap( )      ==>This constructor creates a default hash map.
HashMap(Map<? extends K,? extends V> m) ==>The form is to initialize the hash map using the elements of m.
HashMap(int capacity) ==>The third form initializes the capacity of the hash map to capacity.
HashMap(int capacity,float fillRatio) ==> The fourth form initializes both the capacity and fill ratio of the hash
    map by using its arguments. The meaning of capacity and fill ratio is
    the same as for HashSet, described earlier. The default capacity is 16.
    The default fill ratio is 0.75
==>There are no any special defined methods of its own defined in HashMap class.

    2.CREATING A MAP USING HASHMAP CLASS AND STORING OBJECTS=>
    Note:
    • Alternatively, you could use interface type (Map) to declare the hashMap object. For
     example ==>
    Map<Double, String> hMap = new HashMap<Double, String>();
    • Always use generics and diamond operator to declare a new map.
    • As you can see in the output, a HashMap does not impose any order on its key-value
    elements.
    • If you put an object with the same key value, it will overwrite the previous one

    3.REMOVING OBJECTS FROM THE MAP ==>
    Methods             Description
    V remove(Object k) ==> Removes the entry whose key equals k.
    default boolean remove(Object k,Object v) ==> If the key/value pair specified by k and v is in the invoking map, it is
removed and true is returned. Otherwise, false is returned.
    default boolean replace(K k,V oldV,V newV) ==> If the key/value pair specified by k and oldV is in the invoking map, the
value is replaced by newV and true is returned. Otherwise, false is returned.
    default V replace(K k,V v) ==> If the key specified by k is in the invoking map, its value is set to v and
the previous value is returned. Otherwise, null is returned.

=====>
Note:
• The remove(Object key) method removes the mapping for a key from the map if it is present (we
care about only the key, and the value does not matter). This method returns the value to which
the map previously associated the key, or null if the map doesn’t contain mapping for the key.
• Similarly, the remove(Object key, Object value) method removes the mapping of a specified key
and specified value, and returns true if the value was removed. This method is useful in case we
really care about the key and value to be removed.
• The replace(K key, V value) method replaces the entry for the specified key only if it is currently
mapping to some value. Ths method returns the previous value with the specified key.


    4.Accessig Objects from a MAP CONTAINER
    METHODS                 DESCRIPTION
    V get(Object k) ==> Returns the value associated with the key k. Returns Null if the key is not found.
    default V getOrDefault(Object k,V defVal) ==> Returns the value associated with k
    if it is in the map. Otherwise, defVal is returned.
    int hashCode() ==>Returns the hash code for the invoking map.
    boolean isEmpty() ==> Returns true if the invoking map is empty. Otherwise, returns false.
    boolean containsValue(Object v) ==Returns true if the map contains v as a value. Otherwise, returns false.
    int size() ==> Returns the number of key/value pairs in the map.
    Collection<V>values() ==> Returns a collection containing the values in the map. This method
provides a collection-view of the values in the map

    5.MAP ITERATION ==>
    As a Map is not a true collection, there is no direct method for iterating over a map. Instead, we can iterate over a
    map using its collection views. Any Map’s implementation has to provide the following four Collection view
    methods:
Methods                                 Description
keySet() ==>Returns a Set view of the keys contained in the map. Hence we can iterate over the
            keys of the map.
values() ==>Returns a collection of values contained in the map. Thus we can iterate over
values of the map.
entrySet() ==>Returns a Set view of the mappings contained in this map. Therefore, we can
              iterate over mappings in the map using the set view.
forEach()and Lambda expression ==> Additionally, you can use the Lambda expressions and
                                     the forEach() statement to view the map container.
    * * */
}

//1.CREATING A MAP
/* This example creates a map container and add objects into it using the
put() method. */
class HashMapCreateDemo {
    public static void main(String args[]) {
// Create a hash map object as a container.
        HashMap<Double, String> hMap = new HashMap<Double, String>();//Key->dbl,Object->String
// Put elements to the map container
        hMap.put(200.0, "OK");
        hMap.put(303.0, "See Other");
        hMap.put(404.0, "Not Found");
        hMap.put(500.0, "Internal Server Error");
        System.out.println(hMap); // Printing the container hmap
        //hmap is a collection of objects or a table
    }
}

//2.Creating map with duplicate valus
/* This example creates a map container using the put() method and with duplicate
entries. */
class HashMapDuplicateDemo {
    public static void main(String args[]) {
// Create a hash map object as a container.
        HashMap<Integer, String> hMap = new HashMap<Integer, String>();
// Put elements to the map container with duplicates
        hMap.put(200, "OK");
        hMap.put(303, "See Others");//Will not be printed==>Will be overritten
        hMap.put(404, "Not Found");
        hMap.put(500, "Internal Server Error");
        hMap.put(303, "Invalid entry");
        hMap.put(101, "See Other");
        System.out.println(hMap);//Printing the container
    }
}

//3.Copying a Map into another
/* This example creates a map container that copies elements from an existing map. */
class HashMapCopyDemo {
    public static void main(String args[]) {
// Create a hash map object as a container.
        Map<String, Double> hMap1 = new HashMap<>();
// Put elements to the map container
        hMap1.put("John Doe", new Double(3434.34));
        hMap1.put("Tom Smith", new Double(123.22));
        hMap1.put("Jane Baker", new Double(1378.00));
        hMap1.put("Tod Hall", new Double(99.22));
        hMap1.put("Ralph Smith", new Double(-19.08));
        System.out.println(hMap1); // Printing the container
// Create a copy of a hMap1 to hMap2
        Map<String,Double> hMap2 = new HashMap<>(hMap1);
// Add data into hMap2
        hMap2.put("Robin Keith", new Double(423.22));
        hMap2.put("Peter Hwang", new Double(178.00));
        System.out.println(hMap2); // Printing the container==>All doesnt prints
    }
}
//4.Retrieving objects of map container
/* This example illustrates how an object stored in a map framework can be accessed
using get(). */
class HashMapAcsessDemo {
    public static void main(String args[]) {
// Create a hash map object as a container.
        Map<String, Double> hMap = new HashMap<>();
// Put elements to the map container
        hMap.put("John Doe", new Double(3434.34));
        hMap.put("Tom Smith", new Double(123.22));
        hMap.put("Jane Baker", new Double(1378.00));
        hMap.put("Tod Hall", new Double(99.22));
        hMap.put("Ralph Smith", new Double(-19.08));
// Deposit 1000 into John Doe's account.
        double balance = hMap.get("John Doe");
        hMap.put("John Doe", balance + 1000);
        System.out.println("John Doe's current balance: " + hMap.get("John Doe"));
    }
}

//5.Removing Objects From a Map Container
/* There are two methods, namely remove() and replace() that you can use for remove an
entry in a map framework. The following example illustrates how an object stored in a
map framework can be removed. */
class HashMapRemoveDemo {
    public static void main(String args[]) {
// Create a hash map object as a container.
        Map<String, Double>hMap = new HashMap<>();
// Put elements to the map container
        hMap.put("John Doe", new Double(3434.34));
        hMap.put("Tom Smith", new Double(123.22));
        hMap.put("Jane Baker", new Double(1378.00));
        hMap.put("Tod Hall", new Double(99.22));
        hMap.put("Ralph Smith", new Double(-19.08));
        Double val = hMap.remove("Jane Baker");
        if (val != null) {System.out.println("Removed value: " + val);}
        System.out.println(hMap);
        hMap.remove("Tod Hall", 99.22);
        System.out.println(hMap);
        hMap.replace("Ralph Smith", 545.67);
        System.out.println(hMap);
    }
}
//6.
/* There are two methods, namely size() and isEmpty() that can be used to
check the status of a map container. The following example illustrates how
an object stored in a map framework can be viewed. */
class HashMapViewDemo {
    public static void main(String args[]) {
// Create a hash map object as a container.
        HashMap<Integer, String>hMap = new HashMap<Integer, String>();
// Put elements to the map container
        hMap.put(200, "OK");
        hMap.put(303, "See Other");
        hMap.put(404, "Not Found");
        hMap.put(500, "Internal Server Error");
// Checking the container
        if (hMap.isEmpty()) {
            System.out.println("Error: The container is empty");
        } else {
            System.out.println(hMap); // Printing the container
        }
// Printing the size of the container
        System.out.println("Size : " + hMap.size());
    }
}

//7.Map Iteration
/* This program illustrates the above here ways f iterating over a map container */
class HashMapIterationDemo {
    public static void main(String args[]) {
// Create a hash map object as a container.
        Map<String, String> mapCountryCodes = new HashMap<>();
        mapCountryCodes.put("1", "USA");
        mapCountryCodes.put("44", "United Kingdom");
        mapCountryCodes.put("33", "France");
        mapCountryCodes.put("81", "Japan");
        mapCountryCodes.put("91", "India");
// Collection view using keySet()
        Set<String> setCodes = mapCountryCodes.keySet();//Using Set to call KeySet()
        Iterator<String> iterator = setCodes.iterator();
        while(iterator.hasNext()) {
            String code = iterator.next();
            String country = mapCountryCodes.get(code);
            System.out.println(code + " => "+ country);
        }
        // Collection view using values()
        Collection<String> countries = mapCountryCodes.values();
        for(String country : countries) {
            System.out.println(country);
        }
// Collection view using entrySet()
        Set<Map.Entry<String, String>> entries =
                mapCountryCodes.entrySet();
        for(Map.Entry<String, String>entry : entries) {
            String code = entry.getKey();
            String country = entry.getValue();
            System.out.println(code + " => "+ country);
        }
// Collection view using Lambda expression
        mapCountryCodes.forEach((code, country) ->
                System.out.println(code + " => "+ country));
    }
}

//8.BULK OPERATIONS==>
/*
There are the following two bulk operations with maps:
        Methods      Description
        clear() ==>The clear() method removes all mappings from the map. The map will be empty after
        this method returns.
        putAll() ==>The putAll(Map<K, V> m) method copies all of the mappings from the specified map
        to this map.
        */
/* This program illustrates the above here ways f iterating over a map container */
class HashMapBulkOperationDemo {
    public static void main(String args[]) {
// Create two map object containers.
        Map<Integer, String>countryCodesEU = new HashMap<>();
        countryCodesEU.put(44, "United Kingdom");
        countryCodesEU.put(33, "France");
        countryCodesEU.put(49, "Germany");
        Map<Integer, String>countryCodesWorld = new HashMap<>();
        countryCodesWorld.put(1, "United States");
        countryCodesWorld.put(86, "China");
        countryCodesWorld.put(82, "South Korea");
        System.out.println("Before: " + countryCodesWorld);
// Merger two containers using putAll()
        countryCodesWorld.putAll(countryCodesEU);
        System.out.println("After: " + countryCodesWorld);
// Clear one map container
        countryCodesEU.clear();
        System.out.println("Is map empty? "+ countryCodesEU.isEmpty());
    }}